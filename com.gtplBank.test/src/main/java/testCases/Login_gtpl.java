package testCases;

import java.io.File;
import java.io.IOException;

//import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Page_Objects.Login_Page_Objects;
import commonFunctions.Common_Functions;
import commonFunctions.New_Common_Functions;

public class Login_gtpl extends New_Common_Functions {

	//static Logger logger = Logger.getLogger(Login_gtpl.class);

	
	public void login() {

		try {
			//logger.info("Logging into the aplication");

			PageFactory.initElements(driver, Login_Page_Objects.class);

			Login_Page_Objects.userID.sendKeys(properties.getProperty("userID"));
			Login_Page_Objects.password.sendKeys(properties.getProperty("password"));
			Login_Page_Objects.login.click();

		} catch (NoSuchElementException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void extentReport() {

		try {

			login();

			testCase = extentReports.createTest("Verify GTBL Bank Tile");
			testCase.log(Status.INFO, "Navigating To GTBL Bank");
			// driver.get("https://www.google.com/");
			String title = driver.getTitle();

			testCase.log(Status.INFO, "Actual Title : " + title);
			testCase.log(Status.INFO, "Expected Title : " + "GTBL Bank");
			testCase.log(Status.INFO, "Verify Actual & Expected Title");

			if (title.equals(properties.getProperty("uiName"))) {
				testCase.log(Status.PASS, "Actual & Expected Tile Are Equal");

			} else {
				testCase.log(Status.FAIL, "Actual & Expected Tile Are Not Equal");

				TakesScreenshot screenshot = (TakesScreenshot) driver;
				File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
				File fileLocation = new File("GTBL Login.png");
				FileHandler.copy(sourceFile, fileLocation);
				testCase.addScreenCaptureFromPath("GTBL login.png");
			}

		} catch (IOException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
