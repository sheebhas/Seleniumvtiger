package testCase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericLibraries.BaseClass;
import genericLibraries.ListenerImplementation;
@Listeners(genericLibraries.ListenerImplementation.class)
public class TC_02_Test extends BaseClass {
	
	@Test
	public void newOrganizationCreationwithIndustryAndType()
	{
		home.getOrganizationLink().click();
		ListenerImplementation.logger.log(Status.INFO, "click on organization link");
		createorg.getOrganizationCreationIcon().click();
		ListenerImplementation.logger.log(Status.INFO, "click on organization creation link");
		createorg.getOrganizationTF().sendKeys(ppt.readDataFromPropertiesFile("orgname")+jutil.generateRandomNum(100));
		ListenerImplementation.logger.log(Status.INFO, "organization name is entered into text field");
		utility.handlingDropdown(createorg.getIndustryDropDown(), ppt.readDataFromPropertiesFile("value1"));
		ListenerImplementation.logger.log(Status.INFO, "Industry is selected from dropdown");
		utility.handlingDropdown(createorg.getTypeDropDown(), ppt.readDataFromPropertiesFile("value2"));
		ListenerImplementation.logger.log(Status.INFO, "type is selected from dropdown");
	createorg.getGroupRadioButton().click();
	ListenerImplementation.logger.log(Status.INFO, "click on group radio button");
	utility.handlingDropdown(createorg.getAssignedDropDown(), "3");
	ListenerImplementation.logger.log(Status.INFO, "selecting the 3rd dropdown");
		createorg.getSaveButton().click();
		
		if(createorg.getOrgHeader().isDisplayed()) {
			ListenerImplementation.logger.log(Status.PASS, "organization page is displayed");
		}
		else {
			ListenerImplementation.logger.log(Status.FAIL, "organization is not displayed");
		}
		
	}

}
