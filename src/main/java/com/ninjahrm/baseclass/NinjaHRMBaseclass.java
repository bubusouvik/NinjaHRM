package com.ninjahrm.baseclass;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.ninjacrm.webdriverutility.WebdriverUtility;
import com.ninjahrm.genericutility.JSONFileUtility;
import com.ninjahrm.genericutility.Properties;
import com.ninjahrm.objectrepository.HomePage;
import com.ninjahrm.objectrepository.LoginPage;

public class NinjaHRMBaseclass {

	WebdriverUtility webdriver = new WebdriverUtility();
	public WebDriver driver = null;
	JSONFileUtility jsonfile = new JSONFileUtility();
	Properties prop = new Properties();

	@BeforeClass
	public void launchBrowser() throws FileNotFoundException, IOException, ParseException, InterruptedException {

		// Create a HashMap to store preferences
		Map<String, Object> prefs = new HashMap<>();
		// Disable the password manager service
		prefs.put("credentials_enable_service", false);
		// Disable the password manager (for older versions/different scenarios)
		prefs.put("profile.password_manager_enabled", false);

		ChromeOptions chromeoption = new ChromeOptions();
		chromeoption.setExperimentalOption("prefs", prefs);

		String Browser = jsonfile.getDataFromJSON("browser");
		String URL = jsonfile.getDataFromJSON("url");

		if (Browser.equals("chrome")) {
			driver = new ChromeDriver(chromeoption);
		} else if (Browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}
		webdriver.maximizeScreen(driver);
		webdriver.waitForPageLoadImpliciteWait(driver);
		driver.get(URL);

	}

	@BeforeMethod
	public void loginToApp() throws ParseException, FileNotFoundException, IOException {

		String uname = jsonfile.getDataFromJSON("username");
		String pass = jsonfile.getDataFromJSON("password");
		LoginPage login = new LoginPage(driver);
		login.loginToApp(uname, pass);

	}

	@AfterMethod
	public void logoutToApp() {
		HomePage home = new HomePage(driver);
		home.getLogout().click();
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
