package qa.bridgelabz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPageDD {
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

	public LoginPageDD(WebDriver driver ) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void loginToBookStore (String moNum, String pswd) throws InterruptedException {
		myAccount.click();
		mobileNo.sendKeys(moNum);
		password.sendKeys(pswd);
		loginButton.click();
		Thread.sleep(1000);
		
	}

}
