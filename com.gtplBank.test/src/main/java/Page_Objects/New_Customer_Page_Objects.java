package Page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class New_Customer_Page_Objects {
	
	//@FindBy(linkText = "New Customer")
	//@FindBy(partialLinkText = "New Customer")
	//@FindBy(xpath = "//a[@href=\"addcustomerpage.php\"]")
	
	@FindBy(partialLinkText = "New Customer")
	public static WebElement newCustomer;

	@FindBy(xpath = "//input[@name=\"name\"]")
	public static WebElement customername;
	
	@FindBy(xpath = "//input[@name=\"rad1\"]")
	public static WebElement gender;
	
	@FindBy(xpath = "//input[@id=\"dob\"]")
	public static WebElement dateOfBirth;
	
	@FindBy(xpath = "//textarea[@name=\"addr\"]")	
	public static WebElement address;
	
	@FindBy(xpath = "//input[@name=\"city\"]")
	public static WebElement city;
	
	@FindBy(xpath = "//input[@name=\"state\"]")
	public static WebElement state;
	
	@FindBy(xpath = "//input[@name=\"pinno\"]")
	public static WebElement pin;
	
	@FindBy(xpath = "//input[@name=\"telephoneno\"]")
	public static WebElement telephoneNumber;
	
	@FindBy(xpath = "//input[@name=\"emailid\"]")
	public static WebElement email;
	
	@FindBy(xpath = "//input[@name=\"sub\"]")
	public static WebElement submit;
}
