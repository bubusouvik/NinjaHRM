package com.ninjahrm.project;

import org.testng.annotations.Test;

import com.ninjacrm.webdriverutility.WebdriverUtility;
import com.ninjahrm.baseclass.NinjaHRMBaseclass;
import com.ninjahrm.genericutility.FileUtility;
import com.ninjahrm.objectrepository.CreateProjectPage;
import com.ninjahrm.objectrepository.HomePage;
import com.ninjahrm.objectrepository.ProjectPage;

public class CreateProject extends NinjaHRMBaseclass {

	WebdriverUtility webutility = new WebdriverUtility();
	FileUtility file = new FileUtility();

	@Test
	public void createProject() throws InterruptedException {

		HomePage home = new HomePage(driver);
		ProjectPage navigateToproject = new ProjectPage(driver);
		home.getProjects().click();
		navigateToproject.getCreateProject().click();
		CreateProjectPage createproject = new CreateProjectPage(driver);
		String drop = webutility.dropdownElement(createproject.getStatus(), "On Going");
		createproject.createProject("CRM" + file.getRandomNumber(), "Souvik", drop);

	}

}
