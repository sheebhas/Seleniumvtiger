package testCase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericLibraries.BaseClass;
import genericLibraries.ListenerImplementation;
@Listeners(genericLibraries.ListenerImplementation.class)
public class TC_07_Test extends BaseClass {

	@Test
	public void ceateEvenetTestcase() throws InterruptedException {
			
			event.getQuickCreateDropdown().click();
			ListenerImplementation.logger.log(Status.INFO, "click on quick create");
			
			utility.handlingDropdown(event.getQuickCreateDropdown() ,"Events");
			ListenerImplementation.logger.log(Status.INFO, "events is selected from drop down");
			event.getSubjectTextField().sendKeys("demo");
			ListenerImplementation.logger.log(Status.INFO, "enter subject into textfield");
			utility.enteringDataIntoElement(driver,"2023-07-28", event.getDatestartTF());
			ListenerImplementation.logger.log(Status.INFO, "enter the date into start date field");
			Thread.sleep(2000);
			
			//homepage.getEndDateTF().sendKeys("2023-07-27");
			
			utility.enteringDataIntoElement(driver,"2023-07-30", event.getEndDateTF());
			ListenerImplementation.logger.log(Status.INFO, "enter the date into end date field");
			Thread.sleep(2000);
			event.getSavebutton().click();
			if(event.getEventHeader().isDisplayed()) {
				ListenerImplementation.logger.log(Status.PASS, "Page is displayed");
			}
			else {
				ListenerImplementation.logger.log(Status.FAIL, "Page is not displayed");
			}
	}
}