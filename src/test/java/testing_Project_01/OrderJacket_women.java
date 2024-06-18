package testing_Project_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderJacket_women {
	WebDriver driver;

	public OrderJacket_women(WebDriver idriver) {
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
	@FindBy(xpath = "//div[@class='product-options-bottom']/descendant::div[5]/button")
	WebElement AddtoCartsel;
	@FindBy(xpath = "//div[@class='columns']/descendant::div[3]/h1")
	WebElement pagetitle;
	@FindBy(xpath = "//div[@class='box-tocart']/div/div[1]/label/span")
	WebElement qty;
	@FindBy(xpath = "//div[@class='box-tocart']/div/div[1]/label/following-sibling::div/input")
	WebElement qty_Nos;
	@FindBy(xpath = "//div[@class='swatch-attribute color']/child::div[2]")
	WebElement errormsg1;
	@FindBy(xpath = "//div[@class='swatch-attribute size']/div/div[3]")
	WebElement Sel_Med_size;
	@FindBy(xpath = "//div[@class='swatch-attribute color']/div/div[1]")
	WebElement Sel_Color;
	@FindBy(xpath = "//div[@class='field qty']/following-sibling::div/button")
	WebElement Add2Cartbtn;
	@FindBy(xpath = "//div[@class='minicart-wrapper']/a")
	WebElement Cart1;

	@FindBy(xpath = "//div[@class='details-qty qty']/label")
	WebElement proceed2checkout;
	@FindBy(xpath = "//div[@class='product-item-pricing']/following-sibling::div/div[1]/a[1]")
	WebElement edit;
	@FindBy(xpath = "//div[@class='product actions']/div/following-sibling::div/a")
	WebElement Removeitem;
	@FindBy(xpath = "//div[@class='modal-inner-wrap']/header/following-sibling::div")
	WebElement Confirmatn_msg_Removeitem;
	@FindBy(xpath = "//div[@class='modal-inner-wrap']/header/following-sibling::footer/button[2]")
	WebElement Removeitem_OK;
	@FindBy(xpath = "//div[@id='minicart-content-wrapper']/div[2]/button/following-sibling::strong")
	WebElement successRemovemsg;
	@FindBy(xpath = "//div[@class='minicart-wrapper']/a")
	WebElement cart;
	
	
	

	
	

	public void placing_order_TC15() throws InterruptedException {

		Actions hoverontab = new Actions(driver); // Mouse hover actions
		hoverontab.moveToElement(jacket1a).build().perform();
		Thread.sleep(900);

		System.out.println("Test******");
		System.out.println(AddtoCart1.isEnabled());
		Assert.assertTrue(AddtoCart1.isEnabled());
		Thread.sleep(600);

		System.out.println(AddtoCart1.isDisplayed());
		AddtoCart1.click();
		Thread.sleep(600);

		System.out.println(pagetitle.getText());

		System.out.println(qty.getText());
		Assert.assertEquals(qty.getText(), "Qty");

		AddtoCartsel.click();
		System.out.println(errormsg1.getText());
		Assert.assertEquals(errormsg1.getText(), "This is a required field.");

		System.out.println("**********************************************");
	}

	public void proceed2Checkout_TC16() throws InterruptedException {
		Sel_Med_size.click();
		Sel_Color.click();
		qty_Nos.clear();
		qty_Nos.sendKeys("6");
		Add2Cartbtn.click();
		Thread.sleep(9000);
		Cart1.click();
		Thread.sleep(2000);
		// edit.click();
	}

	public void Checkoutedit_and_RemoveTC17() throws InterruptedException {
		edit.click();
		System.out.println(pagetitle.getText());
		Assert.assertEquals(pagetitle.getText(), "Olivia 1/4 Zip Light Jacket");
		Thread.sleep(900);
		Cart1.click();
		Thread.sleep(1000);
		System.out.println("____");
		Removeitem.click();
		Thread.sleep(1000);
		System.out.println("____");

		Removeitem_OK.click();
		cart.click();
		Assert.assertEquals(successRemovemsg.getText(), "You have no items in your shopping cart.");
		System.out.println(successRemovemsg.getText());
		Assert.assertTrue(successRemovemsg.isDisplayed());
		System.out.println(successRemovemsg.isDisplayed());
	}

	
}
