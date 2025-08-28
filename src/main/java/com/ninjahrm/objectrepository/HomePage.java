package com.ninjahrm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath = "//*[name()='svg' and contains(@data-icon,'right-from-bracket')]")
	private WebElement logout;

	@FindBy(linkText = "Projects")
	private WebElement projects;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogout() {
		return logout;
	}

	public WebElement getProjects() {
		return projects;
	}

}
