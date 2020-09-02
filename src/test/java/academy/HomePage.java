package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPassword;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resorces.base;

public class HomePage extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());
	public WebDriver driver;

	@BeforeTest

	public void initialize() throws IOException {
		driver = intializeDrive();

	}

	@Test(dataProvider = "getData")

	public void basePageNavigation(String username, String password, String text) throws IOException {

		// One is inhertence
		// Creating object of that class and invoke method of it

		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		LoginPage lp = l.getLogin();

//		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		
		log.info(text);
		
		lp.getLogin().click();
//		System.out.println(text);
		ForgotPassword fp = lp.forgotpassword();
		fp.getEmail().sendKeys("dsadd");
		fp.sendMeInstruction().click();

		
	}

	@AfterTest

	public void teardown() {
		driver.close();
	}

	@DataProvider
	public Object[][] getData() {

		// Row stands for how many diffrent data types test should run
		// column stands for how many values per each test

		Object[][] data = new Object[2][3];
		// 0th row
		data[0][0] = "restricted@gmail.com";
		data[0][1] = "123456";
		data[0][2] = "Restricted users";

		data[1][0] = "nonrestricted@gmail.com";
		data[1][1] = "123456";
		data[1][2] = "non Restricted users";

		return data;
	}
}
