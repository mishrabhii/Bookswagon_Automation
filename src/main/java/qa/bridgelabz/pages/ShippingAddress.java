package qa.bridgelabz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingAddress {

	public WebDriver driver;

	@FindBy(id = "ctl00_cpBody_txtNewRecipientName")
	WebElement recipientName;
	
	
	

	public ShippingAddress(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}


	public void shippingAD() throws InterruptedException {
		Thread.sleep(500);
		recipientName.sendKeys("Abhishek Mishra");
		Thread.sleep(500);
	

	}

}
