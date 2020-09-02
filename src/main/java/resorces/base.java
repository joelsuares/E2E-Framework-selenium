package resorces;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver intializeDrive() throws IOException {
		

		 prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Admin\\eclipse-workspace\\E2Eproject\\src\\main\\java\\resorces\\data.properties");
		prop.load(fis);

		String browsername = prop.getProperty("browser");
		System.out.println(browsername);

		if (browsername.equals("chrome")) {
			// chrome code
			System.setProperty("webdriver.chrome.driver", "D:\\selenium_new\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\selenium_new\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browsername.equals("IE")) {

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		return driver;
	}
	
	public String getScreenShotPath(String testcasename,WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
		org.apache.commons.io.FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		
		
		
	}
}
