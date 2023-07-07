package testCase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericLibraries.BaseClass;
import genericLibraries.ListenerImplementation;
@Listeners(genericLibraries.ListenerImplementation.class)
public class TC_04_Test extends BaseClass {

	@Test
	public void newContactCreationWithExistingOrganization () throws InterruptedException
	{
		home.getContactsLink().click();
		ListenerImplementation.logger.log(Status.INFO, "click on contacts link");
		contact.getCreatingContactPlusIcon().click();
		ListenerImplementation.logger.log(Status.INFO, "click on contacts + icon");
		contact.getLastNameTf().sendKeys(ppt.readDataFromPropertiesFile("lastname")+jutil.generateRandomNum(100));
		ListenerImplementation.logger.log(Status.INFO, "type last name in text field");
		String parentId = driver.getWindowHandle();
		contact.getExistingOrganizationSelectionIcon().click();
		ListenerImplementation.logger.log(Status.INFO, "click on existing organization selection icon");
		utility.switchingtargetPage(driver,driver.getWindowHandles(), parentId);
		ListenerImplementation.logger.log(Status.INFO, "controlled to child browser");
		Thread.sleep(2000);
		contact.getExixtingOrganizationName().click();
		ListenerImplementation.logger.log(Status.INFO, "click on existing org name");
		Thread.sleep(2000);
		utility.switchingBackToMain(driver,parentId);
		ListenerImplementation.logger.log(Status.INFO, "switching to parentid ");

		createorg.getSaveButton().click();
		if(contact.getContactHeader().isDisplayed()) {
			ListenerImplementation.logger.log(Status.PASS, "page is displayed");
		}
		else {
			ListenerImplementation.logger.log(Status.FAIL, "page is not displayed");
		}
	}
}
