package PomPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingLeads {

	@FindBy(xpath="//img[@alt=\"Create Lead...\"]")
	private WebElement leadscreationIcon;

	@FindBy(name="lastname")
	private WebElement lastNameTf;
	@FindBy(name="firstname")
	private WebElement firstnNameTf;

	public WebElement getFirstnNameTf() {
		return firstnNameTf;
	}
	@FindBy(name="company")
	private WebElement companyTf;

	@FindBy(xpath="//input[@value='Duplicate']")
	private WebElement duplicateLeadbutton;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement leadHeader;
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement duplicateHeader;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement saveHeader;

	public WebElement getSaveHeader() {
		return saveHeader;
	}
	public WebElement getDuplicateHeader() {
		return duplicateHeader;
	}
	public WebElement getLeadHeader() {
		return leadHeader;
	}
	public WebElement getDeleteLeadcheckBox() {
		return deleteLeadcheckBox;
	}
	@FindBy(name="Delete")
	private WebElement deleteLeadButtoninLeadsInformationPage;

	@FindBy(xpath="//input[@value=\"Delete\"]")
	private WebElement deleteButtonInLeadsPge;

	public WebElement getDeleteLeadButtoninLeadsInformationPage() {
		return deleteLeadButtoninLeadsInformationPage;
	}
	public WebElement getDeleteButtonInLeadsPge() {
		return deleteButtonInLeadsPge;
	}
	@FindBy(id="selectCurrentPageRec")
	private WebElement deleteLeadcheckBox;

	@FindBy(xpath="//input[@value=\"Delete\"]")
	private WebElement deleteButton;

	public WebElement getDeleteButton() {
		return deleteButton;
	}
	public WebElement getDuplicateLeadbutton() {
		return duplicateLeadbutton;
	}

	@FindBy(xpath="//input[normalize-space(@value)='Save']")
	private WebElement saveButton;

	public CreatingLeads(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getLeadscreationIcon() {
		return leadscreationIcon;
	}
	public WebElement getLastNameTf() {
		return lastNameTf;
	}
	public WebElement getCompanyTf() {
		return companyTf;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}

}
