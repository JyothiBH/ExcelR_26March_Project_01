package master_01;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jdk.internal.classfile.impl.Options;
import testing_Project_01.Acc_Creation_SignIn;
import testing_Project_01.AddingtoMyWishList;
import testing_Project_01.OrderPlacement_success;
import testing_Project_01.OrderJacket_women;
import testing_Project_01.WelcomeUser_Dropdown;
import testing_Project_01.StoreMenu_Test;

public class MasterClass_01 {

	ChromeOptions options = new ChromeOptions();
	WebDriver driver = new ChromeDriver();

	Acc_Creation_SignIn accountcreate = new Acc_Creation_SignIn(driver);
	StoreMenu_Test StoreMenu = new StoreMenu_Test(driver);
	WelcomeUser_Dropdown Username_drpdn = new WelcomeUser_Dropdown(driver);
	OrderJacket_women anOrderplacing = new OrderJacket_women(driver);
	AddingtoMyWishList wishlist = new AddingtoMyWishList(driver);
	OrderPlacement_success OrderPlacement = new OrderPlacement_success(driver);
	
	
	@DataProvider(name = "testdata1")
	public Object[][] LoginData() {
		Object[][] data = new Object[1][2];

		data[0][0] = "Jyo12@gmail.com";
		data[0][1] = "Samiksha14$";

		return data;
	}
	
	
	@DataProvider(name="Testdata2")
	public Object[][] AddressDetails()
	{
		Object[][] data = new Object[1][4];
		
		data[0][0] ="Jyothi";
		data[0][1] ="Girish";
		data[0][2] ="Jyoto123@gmail.com";	
		data[0][3] ="Samiksha14$";
		return data;
	}

	
	@Test(priority = 1)
	public void launchapp() throws InterruptedException 
	{
		accountcreate.LaunchApplication_TC1();
	}
	
	
	@Test(dataProvider="Testdata2",priority = 2)
	public void CreatingNewUser(String firstnme, String lastnme, String email, String pswd) throws InterruptedException
	{
	//accountcreate.Accountcreation_TC2(firstnme,lastnme,email,pswd);  //creating a new user by diff email
	}

	
	@Test(dataProvider = "testdata1", priority = 3)
	public void LoginApp(String username, String password) throws InterruptedException
	{
	accountcreate.Signin_TC3(username, password);      /* Reusing the same username */
	}

	@Test(priority = 4)
	public void Application_Testing1() throws InterruptedException, IOException {

		accountcreate.closingAdPopup_TC4();
		StoreMenu.StoreMenuWomen_TC5();
		StoreMenu.Sortbyfunction_TC6();           //sort by Function menu
		StoreMenu.SearchStore_TC7("Neve Studio"); /* input parameter is any product to be searched*/
	}
	
	@Test(priority = 5)
	public void Application_Testing2() throws InterruptedException, IOException
	{
		Username_drpdn.username_dropdown_TC8(); 
		Username_drpdn.Enter_Cntct_Info_TC9(); //
	//	Username_drpdn.Enter_StreetAddress_TC10("HP", "9112345", "jaynagar", "Bangalore", "12345");
		Username_drpdn.screenshot_TC11();
		Username_drpdn.default_addrress_TC12();
	}
	
	@Test(priority = 6)
	public void Application_Testing3() throws InterruptedException
	{
		wishlist.Add_MyWishList_TC_13();
		wishlist.WishListPage_buttons_TC14a();
		wishlist.WishListPage_buttons_TC14b();
		wishlist.WishListPage_buttons_TC14c();
		StoreMenu.StoreMenuWomen_TC5();
	}
	
	@Test(priority = 7)
	public void Application_Testing4() throws InterruptedException
	{
		anOrderplacing.placing_order_TC15();
		anOrderplacing.proceed2Checkout_TC16();
		anOrderplacing.Checkoutedit_and_RemoveTC17();
	}
	
	@Test(priority = 8)
	public void Application_Testing5() throws InterruptedException
	{
		OrderPlacement.proceedtocheckout_TC18();
		OrderPlacement.Review_and_Payment_TC19();
		OrderPlacement.OrderConfirmation_TC20();
	}
}
