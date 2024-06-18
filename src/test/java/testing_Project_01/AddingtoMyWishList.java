package testing_Project_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddingtoMyWishList {
	WebDriver driver;

	public AddingtoMyWishList(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Olivia 1/4 Zip Light Jacket ')]")
	WebElement jacket1;
	@FindBy(xpath = "//div[@class='product details product-item-details']/child::div[3]/div/div/form/button")
	WebElement AddtoCart1;
	@FindBy(linkText = "Olivia 1/4 Zip Light Jacket")
	WebElement jacket1a;
	@FindBy(xpath = "//div[@class='product details product-item-details']/div[3]/div/child::div[2]/child::a[1]")
	WebElement AddtoWishList;
	@FindBy(xpath = "//div[@role='alert']/div")
	WebElement successmsg;
	@FindBy(linkText = "here")
	WebElement linktxt;
	@FindBy(xpath = "//button[@title='Update Wish List']/span")
	WebElement Updtewishlist_btn;
	@FindBy(xpath = "//button[@title='Share Wish List']/span")
	WebElement Sharewishlist_btn;
	@FindBy(xpath = "//button[@title='Add All to Cart']/span")
	WebElement AddAlltocart_btn;
	@FindBy(xpath = "//nav[@class='navigation']/ul/li[2]/a/span[1]")
	WebElement women;
	@FindBy(xpath = "//nav[@class='navigation']/descendant::span[4]")
	WebElement Tops;
	@FindBy(xpath = "//nav[@class='navigation']/descendant::span[6]")
	WebElement Jackets;

	public void Add_MyWishList_TC_13() throws InterruptedException {
		Actions hoverontab = new Actions(driver); // Mouse hover actions
		hoverontab.moveToElement(women).build().perform();
		Thread.sleep(900);
		hoverontab.moveToElement(Tops).build().perform();
		hoverontab.moveToElement(Jackets).click().build().perform();
		
		
		String x = AddtoWishList.getAccessibleName();
		System.out.println(x);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(jacket1a).build().perform();
		actions.moveToElement(AddtoWishList).click().build().perform();
		
		
		Thread.sleep(1000);
		System.out.println("tc9");
		System.out.println(successmsg.getText());
		String successmsg1 = "Olivia 1/4 Zip Light Jacket has been added to your Wish List. Click here to continue shopping.";
		Assert.assertEquals(successmsg.getText(), successmsg1);
		Assert.assertTrue(linktxt.isDisplayed());
		System.out.println("**********************************************");
	}

	public void WishListPage_buttons_TC14a() {
		
		Assert.assertTrue(Updtewishlist_btn.isDisplayed());		// to check 3 buttons
		System.out.println(Updtewishlist_btn.getText());
		System.out.println(Updtewishlist_btn.isDisplayed());

		}
	
public void WishListPage_buttons_TC14b() {
		
		Assert.assertTrue(Sharewishlist_btn.isDisplayed());
		System.out.println(Sharewishlist_btn.getText());
		System.out.println(Sharewishlist_btn.isDisplayed());

		}
public void WishListPage_buttons_TC14c() {
	
	Assert.assertTrue(AddAlltocart_btn.isDisplayed());
	System.out.println(AddAlltocart_btn.getText());
	System.out.println(AddAlltocart_btn.isDisplayed());
	System.out.println("**********************************************");

}
	
	
	
	
}
