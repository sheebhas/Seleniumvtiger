package testCase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericLibraries.BaseClass;
import genericLibraries.ListenerImplementation;
@Listeners(genericLibraries.ListenerImplementation.class)
public class TC_03_Test extends BaseClass {

	@Test
	public void newContactCreation() {
		home.getContactsLink().click();
		ListenerImplementation.logger.log(Status.INFO, "click on contacts link");
		contact.getCreatingContactPlusIcon().click();
		ListenerImplementation.logger.log(Status.INFO, "click on contact + icon");
		contact.getLastNameTf().sendKeys(ppt.readDataFromPropertiesFile("lastname") + jutil.generateRandomNum(100));
		ListenerImplementation.logger.log(Status.INFO, "type the last name in text field");
		contact.getSaveButton().click();
		if(contact.getContactHeader().isDisplayed()) {
			ListenerImplementation.logger.log(Status.PASS, "Contact page is displayed");
		}
		else {
			ListenerImplementation.logger.log(Status.FAIL, "contact page is not displayed");
		}
	}
}
