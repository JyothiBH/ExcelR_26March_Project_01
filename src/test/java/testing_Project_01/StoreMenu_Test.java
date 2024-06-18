package testing_Project_01;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StoreMenu_Test {

	WebDriver driver;

	// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	public StoreMenu_Test(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//nav[@class='navigation']/ul/li[2]/a/span[1]")
	WebElement women;
	@FindBy(xpath = "//nav[@class='navigation']/descendant::span[4]")
	WebElement Tops;
	@FindBy(xpath = "//nav[@class='navigation']/descendant::span[6]")
	WebElement Jackets;
	@FindBy(xpath = "//main[@id='maincontent']/div/h1/span")
	WebElement JacketPageTitle;
	@FindBy	(id="search") WebElement searchwindow;
	@FindBy	(xpath="//div[@class='minicart-wrapper']/a") WebElement cart;
	
	@FindBy	(xpath="//div[@class='search-autocomplete']/ul/li[1]/span[1]") WebElement searchdropdown;
	@FindBy	(xpath="//div[@class='page-title-wrapper']/h1/span") WebElement Searchresultmsg;
	
	
	

	public void StoreMenuWomen_TC5() throws InterruptedException {
		Actions hoverontab = new Actions(driver); // Mouse hover actions
		hoverontab.moveToElement(women).build().perform();
		Thread.sleep(900);
		hoverontab.moveToElement(Tops).build().perform();
		hoverontab.moveToElement(Jackets).click().build().perform();
		String expected3 = JacketPageTitle.getText();
		String actual3 = "Jackets";

		Assert.assertEquals(expected3, actual3);
		System.out.println("Page Title is : " + expected3);
		System.out.println("**********************************************");
	}

	public void Sortbyfunction_TC6() throws InterruptedException {

		WebElement sort = driver.findElement(By.xpath("//div[@id='authenticationPopup']/following-sibling::div[1]/child::div[3]/select")); // Dropdown selection
		Select sel = new Select(sort);
		System.out.println("Default selected sort option is: "+sel.getFirstSelectedOption().getText());
		List<WebElement> list1 = sel.getOptions();
		int sorttinglist = list1.size();
		System.out.println("numer of sort options"+sorttinglist);
		
		sel.selectByIndex(1);
		Thread.sleep(2000);
		
		//explicit wait:
			
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='authenticationPopup']/following-sibling::div[1]/child::div[3]/select")));
		System.out.println("**********************************************");	
	}
	
	public void SearchStore_TC7(String searchproduct)
	{
	
		Assert.assertTrue(searchwindow.isDisplayed());
		Assert.assertTrue(cart.isDisplayed());
		
		searchwindow.sendKeys(searchproduct);
		
		System.out.println(searchdropdown.getText());
		System.out.println(searchdropdown.isDisplayed());
		searchwindow.submit();
		
		System.out.println(Searchresultmsg.getText());
		Assert.assertEquals(Searchresultmsg.getText(), "Search results for: 'Neve Studio'");
		System.out.println("**********************************************");
		
		
	}
	
	
	
	
	
	
	
}
