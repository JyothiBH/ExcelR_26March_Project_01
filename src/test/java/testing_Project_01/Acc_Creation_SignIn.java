package testing_Project_01;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Acc_Creation_SignIn {

	WebDriver driver ;
	
	
	public Acc_Creation_SignIn(WebDriver idriver) 
	{
		driver = idriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (linkText="Create an Account") WebElement createanaccountlink;
	@FindBy (xpath="//div[@class='page-title-wrapper']/h1/span") WebElement PageTitle;
	
	@FindBy	(id="firstname") WebElement firstname;
	@FindBy	(id="lastname") WebElement lastname;		
	@FindBy	(name="email") WebElement email;
	@FindBy (id="password") WebElement password;
	@FindBy (name="password_confirmation") WebElement confirmpassword;
	@FindBy	(xpath="//*[contains(@title,'Create an Account')]") WebElement createaccntbtn;
	@FindBy	(linkText="Sign In") WebElement signinlink; 
	@FindBy	(id="email") WebElement emailusername;
	@FindBy	(id="pass") WebElement Password;
	@FindBy	(xpath="//button[@class='action login primary']/span") WebElement SignInbutton;
	@FindBy	(xpath="//li[@class='greet welcome']/span") WebElement Welcomeusername;
	@FindBy (xpath="//nav[@class='navigation']/descendant::li[1]/a/span") WebElement whatsnewmenu;
	@FindBy (xpath="//div[@class='page-title-wrapper']/h1/span") WebElement whatsnewtitle;
	@FindBy (xpath="//div[@class='ea-stickybox-hide']") WebElement closex;
	@FindBy (xpath = "//div[@class='ea-text']") WebElement text11;
	
		
	public void LaunchApplication_TC1() throws InterruptedException
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://magento.softwaretestingboard.com/");
		Thread.sleep(2000);
	}
	
	public void Accountcreation_TC2(String firstnme,String lastnme,String e_mail,String pswd) throws InterruptedException
	{
		createanaccountlink.click();
		Thread.sleep(900);
		String x=PageTitle.getText();
		String y = "Create New Customer Account";
		Assert.assertEquals(x, y);
		
		System.out.println("PageTitle of creating new account is: "+x);
		firstname.sendKeys(firstnme);
		lastname.sendKeys(lastnme);
		email.sendKeys(e_mail);
		password.sendKeys(pswd);
		confirmpassword.sendKeys(pswd);
		createaccntbtn.click();
		Thread.sleep(1000);
		//return e_mail;
		System.out.println("**********************************************");
	}
	
		
		public void Signin_TC3(String usernme, String pswd) throws InterruptedException
		{
		signinlink.click();
		emailusername.sendKeys(usernme);
		Password.sendKeys(pswd);
		SignInbutton.click();
		Thread.sleep(3000);
				
		String actual1 = Welcomeusername.getText();
		String expected1 = "Welcome, Jyothi Girish!";
	//	Assert.assertEquals(actual1, expected1);  TEMPORARY ITS COMMENTED
			
		whatsnewmenu.click();
		Thread.sleep(900);
		
		String actual2 = whatsnewtitle.getText();
		String expected2 = "What's New";
		Assert.assertEquals(actual2, expected2);
														
		System.out.println("Page Title on clicking Whats new 1st menu is: "+whatsnewtitle.getText());
		System.out.println("**********************************************");
	}
		
		public void closingAdPopup_TC4() throws InterruptedException 
		{
			System.out.println(text11.getText());
			closex.click();
			Thread.sleep(900);
			System.out.println("**********************************************");
		}
	
	
}
