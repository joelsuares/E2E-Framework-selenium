package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resorces.base;

public class validateNavigationbar extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());
	public WebDriver driver;

	@BeforeTest

	public void initialize() throws IOException {
		driver = intializeDrive();
		driver.get(prop.getProperty("url"));
	}

	@Test()

	public void basePageNavigation() throws IOException {

		// One is inhertence
		// Creating object of that class and invoke method of it

		LandingPage l = new LandingPage(driver);
		// compare txt from browser with actual txt
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("Navigated sucessfully");
		

	}

	@AfterTest

	public void teardown() {
		driver.close();
	}

}
