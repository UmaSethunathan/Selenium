package com.Razorfish.Myproject1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class TestLogin {
	Properties OR;
	File f;
	FileInputStream file;

	public String getData(String ElementName) throws Exception {
		// Read value using the logical name as Key
		String data = OR.getProperty(ElementName);
		return data;
	}
	
	/**
	 * 
	 * @param ElementName
	 * @return
	 * @throws Exception
	 */
	public By getLocator(String ElementName) throws Exception {
		// Read value using the logical name as Key
		String locator = OR.getProperty(ElementName);
		// Split the value which contains locator type and locator value
		String locatorType = locator.split(":")[0];
		String locatorValue = locator.split(":")[1];
		// Return a instance of By class based on type of locator
		if (locatorType.toLowerCase().equals("id"))
			return By.id(locatorValue);
		else if (locatorType.toLowerCase().equals("name"))
			return By.name(locatorValue);
		else if ((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
			return By.className(locatorValue);
		else if ((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
			return By.className(locatorValue);
		else if ((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
			return By.linkText(locatorValue);
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return By.partialLinkText(locatorValue);
		else if ((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
			return By.cssSelector(locatorValue);
		else if (locatorType.toLowerCase().equals("xpath"))
			return By.xpath(locatorValue);
		else
			throw new Exception("Locator type '" + locatorType + "' not defined!!");
	}

	public TestLogin(String filepath) {
		// TODO Auto-generated method stub
		try {
			file = new FileInputStream(filepath);
			OR = new Properties();
			OR.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// TODO Auto-generated method stub

}
