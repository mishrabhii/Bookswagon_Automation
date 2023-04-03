package qa.bridgelabz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout  {
	WebDriver driver;

	@CacheLookup
	@FindBy(id = "ctl00_lblUser")
	WebElement errow;

	@FindBy(id = "ctl00_lnkbtnLogout")
	WebElement lOut;



	public Logout (WebDriver driver ) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void logOutPage() throws InterruptedException {
		Dashboard db2 = new Dashboard(driver);
		db2.searchProductAndAddToWishlist();

		Actions act = new Actions (driver);
		act.moveToElement(errow).perform();
		

		Thread.sleep(5000);
		lOut.click();
		Thread.sleep(4000);


	}
}
