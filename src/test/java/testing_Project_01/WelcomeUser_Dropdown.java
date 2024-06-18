package testing_Project_01;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class WelcomeUser_Dropdown {

	WebDriver driver;

	public WelcomeUser_Dropdown(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@class='customer-welcome']")
	WebElement dropdown;
	@FindBy(linkText = "My Account")
	WebElement MyAccountoptn;
	@FindBy(xpath = "//h1[@class='page-title']/span")
	WebElement MyAccount_Title;
	@FindBy(xpath = "//div[@class='box-content']/p")
	WebElement Contact_info;
	@FindBy(linkText = "Edit")
	WebElement Edit_Link;
	@FindBy(linkText = "Change Password")
	WebElement PswdChange;
	@FindBy(xpath = "//div[@class='block block-dashboard-addresses']/div/strong")
	WebElement Addrss_BK_heading;
	@FindBy(linkText = "Manage Addresses")
	WebElement Manage_Addrlink;
	@FindBy(xpath = "//h1[@class='page-title']")
	WebElement AddNewAddr_Page;
	@FindBy(id = "company")
	WebElement Company;
	@FindBy(id = "telephone")
	WebElement PhoneNum;

	@FindBy(id = "street_1")
	WebElement StreetAdd;
	@FindBy(name = "city")
	WebElement City;
	@FindBy(name = "postcode")
	WebElement Zip;
	@FindBy(id = "region_id")
	WebElement State_Pro;
	@FindBy(id = "country")
	WebElement country_sel;
	@FindBy(xpath = "//button[@title='Save Address']")
	WebElement Save_address;
	@FindBy(xpath = "//div[@class='box box-address-billing']/strong/span")
	WebElement default_bill_address;
	@FindBy(xpath = "//div[@class='box box-address-shipping']/strong/span")
	WebElement default_ship_address;

	public void username_dropdown_TC8() throws InterruptedException {
		dropdown.click();
		Thread.sleep(1000);
		MyAccountoptn.click();

		System.out.println(MyAccount_Title.getText());
		String actual = MyAccount_Title.getText();
		Assert.assertEquals(actual, "My Account");

		System.out.println(Contact_info.getText());
		// String cntact_info = "Jyothi Girish jyo@gmail.com";
		// Assert.assertEquals(Contact_info.getText(), info);
		// Assert.assertSame(Contact_info.getText(), info); NEED help in this assert

		Boolean edit_link = Edit_Link.isDisplayed();
		Assert.assertTrue(edit_link, "Edit link notprovided");
		System.out.println("*******");

		Boolean changepswd = PswdChange.isDisplayed();
		Assert.assertTrue(changepswd, "Change Password linl is not provided");

		System.out.println(Addrss_BK_heading.getText());
		String Address_details = "Address Book";
		Assert.assertEquals(Addrss_BK_heading.getText(), Address_details);
		System.out.println("**********************************************");
	}

	public void Enter_Cntct_Info_TC9() {
		Manage_Addrlink.click();
		System.out.println("**********************************************");
	}

	public void Enter_StreetAddress_TC10(String C_nme, String ph, String add, String city, String zip)
			throws InterruptedException {
		AddNewAddr_Page.getText();
		System.out.println(AddNewAddr_Page.getText());
		String PageTitle = "Add New Address";
		Assert.assertEquals(AddNewAddr_Page.getText(), PageTitle);
		System.out.println(C_nme);

		Company.sendKeys(C_nme);
		PhoneNum.sendKeys(ph);

		StreetAdd.sendKeys(add);
		City.sendKeys(city);
		Zip.sendKeys(zip);

		Select sel = new Select(State_Pro);
		sel.selectByVisibleText("Texas");
		Thread.sleep(800);

		Select sele = new Select(country_sel);
		sele.selectByVisibleText("Togo");
		Thread.sleep(1000);
		Save_address.click();
		Thread.sleep(1000);
		
		
		System.out.println("**********************************************");
	}

	public void default_addrress_TC12() throws InterruptedException {
		/*Alert a = driver.switchTo().alert();
		Thread.sleep(800);
		System.out.println(a.getText());
		a.accept();*/
		String de_addr = default_bill_address.getText();
		System.out.println(default_bill_address.getText());
		Assert.assertEquals(de_addr, "Default Billing Address");

		String sh_addr = default_ship_address.getText();
		System.out.println(default_ship_address.getText());
		Assert.assertEquals(sh_addr, "Default Shipping Address");
		System.out.println("**********************************************");
	}

	public void screenshot_TC11() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src1 = ts.getScreenshotAs(OutputType.FILE);
		File dest1 = new File("C:\\Users\\jyoth\\OneDrive\\Desktop\\Jyothi\\Screenshots\\mynta.jpeg");
		FileHandler.copy(src1, dest1);
		System.out.println("**********************************************");	
	}
}
