package testCase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericLibraries.BaseClass;
import genericLibraries.ListenerImplementation;
@Listeners(genericLibraries.ListenerImplementation.class)
public class TC_01_Test extends BaseClass {
	@Test
	public void newOrganizationCreation() throws InterruptedException
	{
		
		home.getOrganizationLink().click();
		ListenerImplementation.logger.log(Status.INFO, "click on organization link");
		createorg.getOrganizationCreationIcon().click();
		ListenerImplementation.logger.log(Status.INFO, "click on organization creation icon");
		createorg.getOrganizationTF().sendKeys(ppt.readDataFromPropertiesFile("orgname")+jutil.generateRandomNum(100));
		ListenerImplementation.logger.log(Status.INFO, "organization name is entered");
		createorg.getSaveButton().click();
		Thread.sleep(3000);
		if(createorg.getOrgHeader().isDisplayed()) {
			ListenerImplementation.logger.log(Status.PASS, "organization name is displayed");
		}
		else {
			ListenerImplementation.logger.log(Status.FAIL, "organization name is not displayed");
		}
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
