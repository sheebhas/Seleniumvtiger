package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericLibraries.BaseClass;
import genericLibraries.ListenerImplementation;
@Listeners(genericLibraries.ListenerImplementation.class)
public class TC_06_Test extends BaseClass {
	// creating leads , duplicating and deleting
		@Test
		public void newLeadCreationAndDuplicationAndDeletion () throws InterruptedException 
		{
			home.getLeadsLink().click();
			ListenerImplementation.logger.log(Status.INFO, "click on leads link");
			leads.getLeadscreationIcon().click();
			ListenerImplementation.logger.log(Status.INFO, "click on leads creation link");
			leads.getFirstnNameTf().sendKeys(ppt.readDataFromPropertiesFile("firstname"));
			ListenerImplementation.logger.log(Status.INFO, "enter first name into text field");
			leads.getLastNameTf().sendKeys(ppt.readDataFromPropertiesFile("lastname"));
			ListenerImplementation.logger.log(Status.INFO, "enter the last name into text field");
			leads.getCompanyTf().sendKeys(ppt.readDataFromPropertiesFile("company"));
			ListenerImplementation.logger.log(Status.INFO, "enter company name in given field");
			leads.getSaveButton().click();
			if(leads.getLeadHeader().isDisplayed()) {
				ListenerImplementation.logger.log(Status.PASS, "page should be displayed");
			}
			else {
				ListenerImplementation.logger.log(Status.FAIL, "page is not displayed");
			}
			leads.getDuplicateLeadbutton().click();
			if(leads.getDuplicateHeader().isDisplayed()) {
				ListenerImplementation.logger.log(Status.PASS, "page is displayed");
			}
			else {
				ListenerImplementation.logger.log(Status.FAIL, "page is not displayed");
			}
			Thread.sleep(4000);
			
			leads.getSaveButton().click();
			if(leads.getSaveHeader().isDisplayed()) {
				ListenerImplementation.logger.log(Status.PASS, "page is displayed");
			}
			else {
				ListenerImplementation.logger.log(Status.FAIL, "page is not displayed");
			}
			
			leads.getDeleteLeadButtoninLeadsInformationPage().click();
			ListenerImplementation.logger.log(Status.INFO, "delect the lead button leads in infomation page ");
			Thread.sleep(4000);
			driver.switchTo().alert().accept();
			Thread.sleep(4000);
			WebElement checkBox = driver.findElement(By.xpath("//a[contains(text(),'"+ppt.readDataFromPropertiesFile("firstname")+"')]/../..//input[@name=\"selected_id\"]"));
			ListenerImplementation.logger.log(Status.INFO, "selecting the checkbox");
			checkBox.click();
			ListenerImplementation.logger.log(Status.INFO, "click on checkbox");
			Thread.sleep(7000);
			
			leads.getDeleteButtonInLeadsPge().click();
			ListenerImplementation.logger.log(Status.INFO, "delete the leads");
			driver.switchTo().alert().accept();
		Thread.sleep(7000);
			
		}


}
