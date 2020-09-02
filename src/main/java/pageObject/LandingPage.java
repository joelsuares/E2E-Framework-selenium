package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	By signin = By.cssSelector("a[href*='https://rahulshettyacademy.com/sign_in/']");
	By title = By.cssSelector("body:nth-child(2) section:nth-child(5) div.container div.text-center > h2:nth-child(1)");
	By NavBar = By.cssSelector("header:nth-child(2) div.navbar.navbar-default.navbar-static-top:nth-child(3) div.container nav.navbar-collapse.collapse > ul.nav.navbar-nav.navbar-right");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public LoginPage getLogin() {

		 driver.findElement(signin).click();
		 LoginPage lp = new LoginPage(driver);
		 return lp;
	}

	public WebElement getTitle() {

		return driver.findElement(title);
	}
	
	public WebElement getNavigationBar() {

		return driver.findElement(NavBar);
	}
}
