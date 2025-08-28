package com.ninjahrm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProjectPage {

	@FindBy(name = "projectName")
	private WebElement projectname;

	@FindBy(name = "createdBy")
	private WebElement createdBy;

	@FindBy(xpath = "(//select[@name='status'])[2]")
	private WebElement status;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement addProjects;

	public CreateProjectPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProjectname() {
		return projectname;
	}

	public WebElement getCreatedBy() {
		return createdBy;
	}

	public WebElement getStatus() {
		return status;
	}

	public WebElement getAddProjects() {
		return addProjects;
	}

	public void createProject(String pname, String createdby, String option) {

		getProjectname().sendKeys(pname);
		getCreatedBy().sendKeys(createdby);
		getStatus().sendKeys(option);
		getAddProjects().click();

	}

}
