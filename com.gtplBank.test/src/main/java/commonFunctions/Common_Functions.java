package commonFunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Common_Functions {

	public static Properties properties;
	public static WebDriver driver;
	static Logger logger = Logger.getLogger(Common_Functions.class);
	static ExtentReports extentReports;
	static ExtentSparkReporter reporter;
	static ExtentTest testCase;


	public Properties loadPropertiesFile() {

		try {

			FileInputStream inputStream = new FileInputStream("gtplConfig.properies");
			properties = new Properties();
			properties.load(inputStream);
			return properties;

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;

	}
	
	@BeforeSuite
	public void beforeSuite() {

		try {
		//PropertyConfigurator.configure("log4j.properties");
		logger.info("GTBL bank suite begins");
		
		extentReports = new ExtentReports();
		reporter = new ExtentSparkReporter("ExtentReport.html");
		extentReports.attachReporter(reporter);
		logger.info("GTBL bank extent report initiated");
		
		} catch (Exception e)  {
			e.printStackTrace();
		}
	}
	
	@AfterSuite
	public void afterSuite( ) {
		
		extentReports.flush();
	}

	@BeforeTest
	public void launchBrowser() {

		try {
			logger.info("GTBL bank test begins");
			logger.info("Loading the property file");
			loadPropertiesFile();

			String browser = properties.getProperty("browser");
			String driverLocation = properties.getProperty("DriverLocation");
			String url = properties.getProperty("url");

			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", driverLocation);
				logger.info("Launching chrome driver");
				driver = new ChromeDriver();
			}

			else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", driverLocation);
				logger.info("Launching firefox driver");
				driver = new FirefoxDriver();
			}

			driver.manage().window().maximize();
			logger.info("Navigating to application");
			driver.get(url);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			driver.wait();
			// wait.until(ExpectedConditions.and());

		} catch (IllegalStateException e) {
			e.printStackTrace();

		} catch (InterruptedException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void tearBrowser() {
		logger.info("Execution done, Closing the browser");
		driver.quit();
	}
}
