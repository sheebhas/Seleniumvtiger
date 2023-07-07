package genericLibraries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import PomPage.CreatingContacts;
import PomPage.CreatingEvent;
import PomPage.CreatingLeads;
import PomPage.CreatingOrganization;
import PomPage.HomePage;
import PomPage.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public   static WebDriver driver ;
	public PropertiesUtility ppt= new PropertiesUtility();
	public WebDriverUtility utility = new WebDriverUtility();
	public JavaUtility jutil=new JavaUtility();
	public LoginPage login;
	public HomePage home;
	public CreatingOrganization createorg;
	public CreatingContacts  contact;
	public CreatingLeads leads;
	public CreatingEvent event;
 



	@BeforeClass(alwaysRun=true)
	public void launchingBrowser()
	{
		WebDriverManager.chromedriver().setup();
		if(ppt.readDataFromPropertiesFile("browser").equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();

		}
		else
		{
			driver= new EdgeDriver();

		}
		driver.manage().window().maximize();

	}
	@BeforeMethod(alwaysRun=true)
	public void navigationToApplication()
	{
		login=new LoginPage(driver);
		home=new HomePage(driver);
		createorg=new CreatingOrganization(driver);
		contact=new CreatingContacts(driver);
		leads=new CreatingLeads(driver);
		event=new CreatingEvent(driver);
	

		driver.get(ppt.readDataFromPropertiesFile("url"));
		login.getUserNameTF().sendKeys(ppt.readDataFromPropertiesFile("username"));
		login.getPasswordTF().sendKeys(ppt.readDataFromPropertiesFile("password"));
		login.getLoginButton().click();
		driver.manage().timeouts().implicitlyWait(Long.parseLong(ppt.readDataFromPropertiesFile("time")), TimeUnit.SECONDS);
	}
	@AfterMethod
	public void loggingOut(ITestResult result)
	{
		System.out.println("Logged out");


	}
	@AfterClass(alwaysRun=true)
	public void tearDownBrowser()
	{
		driver.navigate().refresh();
		home.getAdministrationIcon().click();
		home.getSignoutButton().click();
		driver.quit();
	}

	
		
	
}
