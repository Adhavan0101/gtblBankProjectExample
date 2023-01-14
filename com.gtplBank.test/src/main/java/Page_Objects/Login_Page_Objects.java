package Page_Objects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page_Objects {

	@FindBy(xpath = "//input[@name=\"uid\"]")
	public static WebElement userID;

	@FindBy(xpath = "//input[@name=\"password\"]")
	public static WebElement password;

	@FindBy(xpath = "//input[@name=\"btnLogin\"]")
	public static WebElement login;

}
