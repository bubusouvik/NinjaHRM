package com.ninjahrm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id = "username")
	private WebElement username;

	@FindBy(id = "inputPassword")
	private WebElement password;

	@FindBy(xpath = "//button[.='Sign in']")
	private WebElement signinBtn;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUseranme() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSignBtn() {
		return signinBtn;
	}

	public void loginToApp(String uname, String pass) {
		getUseranme().sendKeys(uname);
		getPassword().sendKeys(pass);
		getSignBtn().click();
	}

}
