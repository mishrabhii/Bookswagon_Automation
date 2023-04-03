package qa.bridgelabz.pages;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

public class RegistrationToBookStore {
	WebDriver driver;
	public static final String Account_SID = "ACddb20e8120fc955efb36d78fa743d9fb";
	public static final String Auth_TOKEN = "1ce83b301ce52b3efbb4841b1f414a69";
	
	@FindBy(xpath = "/html/body/form/header/div[1]/div/div[3]/ul/li[1]/a")
	WebElement myAccount;

	@FindBy(linkText = "New to Bookswagon? Sign up")
	WebElement signUpLink;

	@FindBy(id = "ctl00_phBody_SignUp_txtName")
	WebElement fullName;
	
	@FindBy(id = "ctl00_phBody_SignUp_ddlCountryMobileCode")
	WebElement CountryMoCode;

	@FindBy(id = "ctl00_phBody_SignUp_txtEmail")
	WebElement mobileNo;

	@FindBy(id = "ctl00_phBody_SignUp_btnContinue")
	WebElement continueButton;  

	@FindBy (id = "ctl00_phBody_SignUp_txtOTP")
	WebElement otp;

	@FindBy (id = "ctl00_phBody_SignUp_txtPassword")
	WebElement password;

	@FindBy (id = "ctl00_phBody_SignUp_txtConfirmPwd")
	WebElement confirmPswd;

	public RegistrationToBookStore(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public String redirectToSignUpPage () throws InterruptedException {
		Thread.sleep(500);
		myAccount.click();
		Thread.sleep(500);
		signUpLink.click();
		Thread.sleep(1000);
		String pageTitle = driver.getTitle();
		return pageTitle;

	}
	public void enterDataIntoElements() throws InterruptedException {
		Thread.sleep(500);
		myAccount.click();
		Thread.sleep(500);
		signUpLink.click();
		Thread.sleep(500);
		fullName.sendKeys("Abhishek Mishra");
		CountryMoCode.click();
		Select sl = new Select(CountryMoCode);
		sl.selectByValue("US +1");
		Thread.sleep(1000);
		mobileNo.sendKeys("5076186170");
		Thread.sleep(500);
		continueButton.click();
		Thread.sleep(500);
		otp.click();
		getotp();
//		password.sendKeys("Abhishek@123");
//		confirmPswd.sendKeys("Abhishek@123");
//		Thread.sleep(1000);
	}	
		public void getotp() throws IllegalStateException {
		Twilio.init(Account_SID, Auth_TOKEN);
String smsBody = getMessage();
System.out.println(smsBody);
	}
	
	
 public String getMessage (){
		return getMessages().filter(m-> m.getDirection().compareTo(Message.Direction.INBOUND)==0)
				.filter(m -> m.getTo().equals("+15076186170")).map (Message::getBody).findFirst().orElseThrow(IllegalStateException::new);
		}
 
		private Stream<Message> getMessages(){
		ResourceSet<Message> messages = Message.reader(Account_SID).read();
		return StreamSupport.stream(messages.spliterator(), false);

}

}
