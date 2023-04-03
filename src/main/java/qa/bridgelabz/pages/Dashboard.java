package qa.bridgelabz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Dashboard {
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
	@FindBy(xpath = "/html/body/form/div[10]/div[1]/div[2]/div[2]/div[1]/div[4]/div[5]/input")
	WebElement addToWishlist;

	@CacheLookup
	@FindBy(xpath = "/html/body/form/header/div[1]/div/div[3]/ul/li[2]/a")
	WebElement addToWishlistbox;

	@CacheLookup
	@FindBy(xpath = "/html/body/form/div[10]/div[1]/div[2]/div[2]/div[1]/div[4]/div[5]/a/input")
	WebElement buyNow;

	@CacheLookup
	@FindBy(id = "BookCart_lvCart_imgPayment")
	WebElement placeOrder;

	public Dashboard(WebDriver driver ) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void searchProductAndAddToWishlist () throws InterruptedException {
		myAccount.click();
		mobileNo.sendKeys("9651094335");
		password.sendKeys("abhishek@123");
		loginButton.click();
		Thread.sleep(1000);
		searchBar.sendKeys("Man's Search For Meaning");
		Thread.sleep(1000);
		searchBook.click();
		Thread.sleep(1000);
		clickOnSearch.click();
		Thread.sleep(1000);
		addToWishlist.click();
		Thread.sleep(1000);
		addToWishlistbox.click();
		Thread.sleep(1000);
		driver.switchTo().parentFrame();
		checkTitle ();
	}

	public void checkTitle () {
		String title = driver.getTitle();
		System.out.println("Title is ="+title );
		Assert.assertEquals("Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com", title);

	}
	

}
