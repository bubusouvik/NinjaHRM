package com.ninjacrm.webdriverutility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

// webdriver utility method
public class WebdriverUtility {

	public void maximizeScreen(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void waitForPageLoadImpliciteWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	public void waitForPageWebDriverWait(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public String dropdownElement(WebElement element, String txt) {

		Select dropdown = new Select(element);
		List<WebElement> options = dropdown.getOptions();
		String dropoption = null;
		for (WebElement option : options) {
			String dropdownoption = option.getText();
			if (dropdownoption.equalsIgnoreCase(txt)) {
				dropdown.selectByVisibleText(dropdownoption);
				dropoption = dropdownoption;
			}
		}
		return dropoption;
	}

}
