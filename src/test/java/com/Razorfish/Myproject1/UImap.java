package com.Razorfish.Myproject1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UImap {
	public WebDriver driver;
	public TestLogin uimap;
	public TestLogin datafile;
	public String workingDir;

	@Test(priority = 1)
	public void login() throws Exception {

		uimap = new TestLogin(workingDir + "\\src\\main\\java\\com\\Razorfish\\Myproject1\\OR.properties");
		// Get object map file

		// Get the firstname element
		WebElement fname = driver.findElement(uimap.getLocator("Firstname_field"));
		fname.sendKeys(datafile.getData("firstname"));
		// System.out.print("Please enter a string: ");
		String stringInput = System.console().readLine();
		int stringLength = stringInput.length();
		if (stringLength > 20) {
			System.out.println("Input string should not exceed 20 characters");
		}

		Thread.sleep(1000);
		// Get the Last name element
		WebElement lname = driver.findElement(uimap.getLocator("Lastname_field"));
		lname.sendKeys(datafile.getData("lastname"));
		String stringIt = System.console().readLine();
		int stringLen = stringIt.length();
		if (stringLen > 20) {
			System.out.println("Input string should not exceed 20 characters");
		}
		// verify phone number field
		String expression = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
		WebElement phone = driver.findElement(uimap.getLocator("Phonenumber"));
		phone.sendKeys(datafile.getData("Phonenumber"));
		phone.toString();
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher((CharSequence) phone);
		// boolean isValid;
		if (matcher.matches()) {
			// isValid = true;
			System.out.println("Phone Number Valid");
		} else {

			System.out.println("Phone Number must be in the form XXX-XXX-XXXX");
		}

		// Click on the Submit button
		WebElement submit = driver.findElement(uimap.getLocator("Submit_button"));
		submit.click();

	}

	@BeforeClass
	public void setUp() throws Exception {

		// Get current working directory and load data file
		workingDir = System.getProperty("user.dir");
		datafile = new TestLogin(workingDir + "\\src\\main\\java\\com\\Razorfish\\Myproject1\\datafile.properties");

		// Create a new instance of the Firefox driver
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://*****.com");
		// driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterMethod() throws Exception {
		driver.quit();
	}

}
