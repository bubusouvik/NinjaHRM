package com.ninjahrm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectPage {

	@FindBy(xpath = "//button[@class='btn btn-success']")
	private WebElement createProject;

	public ProjectPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateProject() {
		return createProject;
	}
}
