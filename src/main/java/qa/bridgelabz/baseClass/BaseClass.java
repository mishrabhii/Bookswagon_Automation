package qa.bridgelabz.baseClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver=null;
	public static Logger log=Logger.getLogger(BaseClass.class.getName());

	public void setup() {
		
		PropertyConfigurator.configure("/Users/atulnigam/Documents/AbhiEclipseWorkshop/BookStore_Framework/log4j.properties");
		BasicConfigurator.configure();

		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://www.bookswagon.com");
		log.info("Bookswagon launch successfully!!!");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void closeWindow() {
		driver.quit();
		log.info("Window quit successfully!!!");
	}
	
	public static void screenshot(String methodName) throws IOException {
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("/Users/atulnigam/Documents/AbhiEclipseWorkshop/BookStore_Framework/Screenshots/"+methodName+".png");
		FileUtils.copyFile(srcFile, destinationFile);
	}

}
