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

public class validateTitle extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());
	public WebDriver driver;

	@BeforeTest

	public void initialize() throws IOException {
		driver = intializeDrive();
		log.info("Driver is intialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
	}

	@Test()

	public void basePageNavigation() throws IOException {

		// One is inhertence
		// Creating object of that class and invoke method of it

		LandingPage l = new LandingPage(driver);
		// compare txt from browser with actual txt
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES123");
		log.info("Succesfully validated text message");

	}

	@AfterTest

	public void teardown() {
		driver.close();
	}

}
