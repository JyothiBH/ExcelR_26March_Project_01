package testing_Project_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderPlacement_success {
	WebDriver driver;

	public OrderPlacement_success(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//nav[@class='navigation']/ul/li[4]")
	WebElement Gear;
	@FindBy(xpath = "//nav[@class='navigation']/ul/li[4]/ul/li/a")
	WebElement Bags;
	@FindBy(xpath = "//div[@class='products wrapper grid products-grid']/ol/li[6]/div//a/span/span/img")
	WebElement Bags_1;
	@FindBy(id = "product-addtocart-button")
	WebElement webelAss2Cart_Bag;
	@FindBy(xpath = "//div[@class='header content']//span/following-sibling::div/a")
	WebElement cart_1;
	@FindBy(xpath = "//div[@class='block-content']/button/following-sibling::div[3]/div/button")
	WebElement Proceed_chkout;
	@FindBy(xpath = "//div[@class='shipping-address-item selected-item']")
	WebElement sel_shipAddr;
	@FindBy(xpath = "//li[@id='shipping']/div[1]")
	WebElement Ship_Pagetitle;
	@FindBy(xpath = "//form[@id='co-shipping-method-form']/div[3]/div/button/span")
	WebElement next_btn;
	@FindBy(xpath = "//fieldset[@class='fieldset']/legend/following-sibling::div[1]/div/div/div[1]")
	WebElement Payment_title;
	@FindBy(xpath = "//div[@class='checkout-billing-address']/div/input")
	WebElement PaymentAddr_chkbox;
	@FindBy(xpath = "//div[@class='checkout-agreements-block']/following-sibling::div/div/button/span")
	WebElement Place_Order;
	@FindBy(xpath = "//div[@class='page-wrapper']/main/div[1]/h1")
	WebElement Order_confirm_Heading;
	@FindBy(xpath = "//div[@class='checkout-success']/div/div/a/span")
	WebElement Continue_shop_btn;
	@FindBy(xpath = "//div[@class='page-wrapper']/main/div/h1")
	WebElement HomePage;
	
	
	public void proceedtocheckout_TC18() throws InterruptedException {

		Actions actions = new Actions(driver);
		actions.moveToElement(Gear).build().perform();
		actions.moveToElement(Bags).click().build().perform();

		Bags_1.click();
		webelAss2Cart_Bag.click();
		Thread.sleep(5000);
		cart_1.click();
		Proceed_chkout.click();

		Assert.assertEquals(Ship_Pagetitle.getText(), "Shipping Address");
		System.out.println(sel_shipAddr.isDisplayed());
		Thread.sleep(1000);
		next_btn.click();
		Thread.sleep(1000);

	}

	public void Review_and_Payment_TC19() throws InterruptedException {

		System.out.println(Payment_title.getText());

		System.out.println(PaymentAddr_chkbox.isSelected());
		Assert.assertTrue(PaymentAddr_chkbox.isSelected());
		PaymentAddr_chkbox.click();

		Thread.sleep(1000);
		System.out.println(PaymentAddr_chkbox.isSelected());
		Assert.assertFalse(PaymentAddr_chkbox.isSelected());

		PaymentAddr_chkbox.click();
		Thread.sleep(1000);
		System.out.println(PaymentAddr_chkbox.isSelected());
		Assert.assertTrue(PaymentAddr_chkbox.isSelected());
		Thread.sleep(1000);
		Place_Order.click();
		Thread.sleep(1000);

	}

	public void OrderConfirmation_TC20() {
		System.out.println(Order_confirm_Heading.getText());
		System.out.println(Order_confirm_Heading.getTagName());

		System.out.println(Continue_shop_btn.isDisplayed());
		Assert.assertTrue(Continue_shop_btn.isDisplayed());
		Continue_shop_btn.click();
		System.out.println(HomePage.isDisplayed());
	}
}
