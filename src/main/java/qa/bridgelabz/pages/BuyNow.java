package qa.bridgelabz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BuyNow {
	WebDriver driver;
	@FindBy(xpath = "/html/body/form/header/div[1]/div/div[3]/ul/li[1]/a")
	WebElement myAccount;

	@CacheLookup
	@FindBy(id = "ctl00_phBody_SignIn_txtEmail")
	WebElement mobileNo;

	@CacheLookup
	@FindBy(id = "ctl00_phBody_SignIn_txtPassword")
	WebElement password;

	@CacheLookup
	@FindBy(id = "ctl00_phBody_SignIn_btnLogin")
	WebElement loginButton;

	@CacheLookup
	@FindBy(id = "inputbar")
	WebElement searchBar;

	@CacheLookup
	@FindBy(xpath = "/html/body/form/header/div[1]/div/div[2]/div/div[2]/div[2]")
	WebElement searchBook;

	@CacheLookup
	@FindBy(id = "btnTopSearch")
	WebElement clickOnSearch;

	@CacheLookup
	@FindBy(xpath = "/html/body/form/div[10]/div[1]/div[2]/div[2]/div[1]/div[4]/div[5]/a/input")
	WebElement buyNow;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id=\"BookCart_lvCart_imgPayment\"]")
	WebElement placeOrder;

	public BuyNow (WebDriver driver ) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
		
	public void buyNow() throws InterruptedException {
		myAccount.click();
		mobileNo.sendKeys("9651094335");
		password.sendKeys("abhishek@123");
		loginButton.click();
		Thread.sleep(1000);
		searchBar.sendKeys("Rich Dad Poor Dad");
		Thread.sleep(1000);
		searchBook.click();
		Thread.sleep(1000);
		clickOnSearch.click();
		Thread.sleep(1000);
		buyNow.click();
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		placeOrder.click();
		Thread.sleep(3000);
	}	

}
