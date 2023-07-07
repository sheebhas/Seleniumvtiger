package PomPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
 
	@FindBy(name="user_name")
	private WebElement userNameTF;
	
	@FindBy(name="user_password")
	private WebElement passwordTF;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getUserNameTF()
	{
		return userNameTF;
	}

	public WebElement getPasswordTF() 
	{
		return passwordTF;
	}

	public WebElement getLoginButton() 
	{
		return loginButton;
	}
}
