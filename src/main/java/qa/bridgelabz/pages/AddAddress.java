package qa.bridgelabz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddAddress {
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
	@FindBy(id = "ctl00_lblUser")
	WebElement userAccount;
	
	@CacheLookup
	@FindBy(xpath = "/html/body/form/div[10]/div/div/div/div/div/div[5]/div")
	WebElement yourAddress;
	@CacheLookup
	
	@FindBy(xpath = "/html/body/form/div[10]/div/div/div/div/div/div[2]")
	WebElement newAddress;
	
	@CacheLookup
	@FindBy(name = "ctl00$phBody$ShippingAddress$txtRecipientName")
	WebElement name;
	
	@CacheLookup
	@FindBy(id = "ctl00_phBody_ShippingAddress_txtAddress")
	WebElement streetAddress;
	
	@CacheLookup
	@FindBy(id = "ctl00_phBody_ShippingAddress_ddlCountry")
	WebElement country;
	
	
	@CacheLookup
	@FindBy(id = "ctl00_phBody_ShippingAddress_ddlState")
	WebElement selectState;
	
	@CacheLookup
	@FindBy(id = "ctl00_phBody_ShippingAddress_imgSubmit")
	WebElement update;

	
	public AddAddress(WebDriver driver ) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void addAddressIntoBookWagon () throws InterruptedException {
		myAccount.click();
		mobileNo.sendKeys("9651094335");
		password.sendKeys("abhishek@123");
		loginButton.click();
		Thread.sleep(1000);
		yourAddress.click();
		Thread.sleep(1000);
		newAddress.click();
		Thread.sleep(1000);
		name.sendKeys("Abhishek Mishra");
		Thread.sleep(1000);
		streetAddress.sendKeys("E-6/85,Dubagga,lucknow");
		Thread.sleep(1000);
		country.click();
		Thread.sleep(1000);
		Select dropDown = new Select(country);
		Thread.sleep(1000);
		dropDown.selectByValue("India");
		selectState.click();
		Select dropDown2 = new Select(selectState);
		dropDown2.selectByValue("Uttar Pradesh");
		Thread.sleep(1000);
		getText();
		
	}
	public void getText() {
		String gText = update.getText();
		Assert.assertEquals("Update", gText);
	}
}
