package testCase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericLibraries.BaseClass;
import genericLibraries.ListenerImplementation;
@Listeners(genericLibraries.ListenerImplementation.class)
public class TC_05_Test extends BaseClass {
	
	@Test
	public void newLeadCreation () 
	{
		home.getLeadsLink().click();
		ListenerImplementation.logger.log(Status.INFO, "click on leads link");
		leads.getLeadscreationIcon().click();
		ListenerImplementation.logger.log(Status.INFO, "click on leads creation icon");
		leads.getFirstnNameTf().sendKeys(ppt.readDataFromPropertiesFile("firstname"));
		ListenerImplementation.logger.log(Status.INFO, "enter first name into text field");
		leads.getLastNameTf().sendKeys(ppt.readDataFromPropertiesFile("lastname")+jutil.generateRandomNum(100));
		ListenerImplementation.logger.log(Status.INFO, "enter last name into text field");
		leads.getCompanyTf().sendKeys(ppt.readDataFromPropertiesFile("company")+jutil.generateRandomNum(100));
		ListenerImplementation.logger.log(Status.INFO, "enter company name in given field");
		leads.getSaveButton().click();
		if(leads.getLeadHeader().isDisplayed()) {
			ListenerImplementation.logger.log(Status.PASS, "page is displayed");
		}
		else {
			ListenerImplementation.logger.log(Status.FAIL, "page is not displayed");
		}
		
	}


}
