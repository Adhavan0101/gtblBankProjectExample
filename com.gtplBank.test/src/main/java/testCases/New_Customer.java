package testCases;

import java.time.Duration;

//import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Page_Objects.New_Customer_Page_Objects;
import commonFunctions.Common_Functions;

public class New_Customer extends Common_Functions {

	//static Logger logger = Logger.getLogger(New_Customer.class);

	@Test
	public void newCustomer() {

		try {
			Login_gtpl login_gtpl = new Login_gtpl();
			login_gtpl.login();
			//logger.info("Login complete, Bank page is opening");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			login_gtpl.wait();

			PageFactory.initElements(driver, New_Customer_Page_Objects.class);

			//logger.info("New customer page is opening");
			New_Customer_Page_Objects.newCustomer.click();
			New_Customer_Page_Objects.customername.sendKeys(properties.getProperty("CustomerName"));
			New_Customer_Page_Objects.gender.click();
			New_Customer_Page_Objects.dateOfBirth.sendKeys(properties.getProperty("DateOfBirth"));
			New_Customer_Page_Objects.address.sendKeys(properties.getProperty("address"));
			New_Customer_Page_Objects.city.sendKeys(properties.getProperty("city"));
			New_Customer_Page_Objects.state.sendKeys(properties.getProperty("state"));
			New_Customer_Page_Objects.pin.sendKeys(properties.getProperty("pin"));
			New_Customer_Page_Objects.telephoneNumber.sendKeys(properties.getProperty("TelephoneNumber"));
			New_Customer_Page_Objects.email.sendKeys(properties.getProperty("email"));
			//logger.info("New customer page entry completed");
			New_Customer_Page_Objects.submit.click();

		} catch (NoSuchElementException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
