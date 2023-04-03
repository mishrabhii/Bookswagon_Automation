package qa.bridgelabz.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import qa.bridgelabz.baseClass.BaseClass;
import qa.bridgelabz.baseClass.ITestListeners;
import qa.bridgelabz.pages.AddAddress;
import qa.bridgelabz.pages.BuyNow;
import qa.bridgelabz.pages.Dashboard;
import qa.bridgelabz.pages.LoginPageDD;
import qa.bridgelabz.pages.Logout;
import qa.bridgelabz.pages.RegistrationToBookStore;
import qa.bridgelabz.utility.Data_provider;

@Listeners(ITestListeners.class)
public class BookStoreTest extends BaseClass {
	RegistrationToBookStore registration;

	@BeforeMethod
	public void initialization () {
		setup();
		registration =  new RegistrationToBookStore(driver);
	}
	@Test(priority = 0)
	public void redirectOnSignup() throws InterruptedException {
		registration.redirectToSignUpPage();
		Thread.sleep(1000);
	}

	@Test(priority = 1)
	public void insertDatainToTheRegistrationField () throws InterruptedException {
		Thread.sleep(1000);
		registration.enterDataIntoElements();
	}

	@Test(priority = 2, dataProvider = "testData", dataProviderClass = Data_provider.class)
	public void loginToBookWagon(String moNum, String pswd) throws InterruptedException {
		Thread.sleep(1000);
		LoginPageDD lp = new LoginPageDD(driver);
		lp.loginToBookStore(moNum, pswd);
	}

	@Test(priority = 3)

	public void dashBoard() throws InterruptedException {
		Dashboard db = new Dashboard(driver);
		db.searchProductAndAddToWishlist();			
	}

	@Test(priority = 4)

	public void buyNow() throws InterruptedException {
		BuyNow bn = new BuyNow(driver);
		bn.buyNow();	
	}
	@Test(priority = 5)

	public void addYourAddress () throws InterruptedException {

		AddAddress aa = new AddAddress(driver);
		aa.addAddressIntoBookWagon();
	}

	@Test(priority = 6)

	public void LogOutToTheBooksWagaon () throws InterruptedException {
		Logout lo = new Logout(driver);
		lo.logOutPage();
	}

	
	@AfterMethod
	public void tearDown() {
		closeWindow();
	}
}
