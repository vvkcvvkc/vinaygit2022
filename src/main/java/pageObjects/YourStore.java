package pageObjects;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class YourStore {

	private WebDriver driver;
	private String pageTitle = "Your Store";

	public YourStore(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath= "//*[@id='content']/div[2]/div[1]/div/div[3]/button[1]")
	private WebElement addToCartButton;
	
	@FindBy(id="wishlist-total")
	private WebElement wishList;
	
	@FindBy(linkText="Shopping Cart")
	private WebElement shoppingCart;
	
	@FindBy(xpath="//*[@id='content']/div[2]/div[1]/div/div[2]/h4/a")
	private WebElement firstProductBtn;
	

	public String returnTitle() {
		return pageTitle;
	}
	public WebElement getShoppingCart() {
		return shoppingCart;
	}
	
	public WebElement getWishList() {
		return wishList;
	}
	
	public WebElement getAddToCartButton()
	{
		return addToCartButton;
	}
	
	public WebElement getFirstProductBtn()
	{
		return firstProductBtn;
	}
	public YourStore clickOnAddToCart( ) throws InterruptedException
	{
		Thread.sleep(2000);
		addToCartButton.click();
		Thread.sleep(3000);
		return this;
		
	}
	public ShoppingCart clickOnShoppingCart()
	{
		getShoppingCart().click();
		return new ShoppingCart(driver);
		
	}
	
	public String retrunFirstProductName()
	{
		return getFirstProductBtn().getText();
	}
	
	
}
