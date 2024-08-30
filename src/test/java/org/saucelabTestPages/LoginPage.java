package org.saucelabTestPages;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import propertiesFile.configReader;
public class LoginPage {
	private WebDriver driver;
	private configReader cr=new configReader();
	
	//WebElements
	@FindBy(css="#user-name")
	public WebElement userNameTxtField;

	@FindBy(id="password")
	public WebElement passwordTxtField;

	@FindBy(css="*[class='submit-button btn_action']")
	public WebElement loginbtn;

	@FindBy(css="div>div.bot_column")
	public List<WebElement> loginlogo;
	//constuctor
	public LoginPage(WebDriver driver) {
		//PageFactory.initElements(driver,LoginPage.class);
		PageFactory.initElements(driver,this);
		driver=new ChromeDriver();
		this.driver=driver;
	}
	//Page action methods

	public boolean isUserNameFieldDispalyed() {
		return userNameTxtField.isDisplayed();
	}

	public boolean isPasswordFieldDisplayed() {
		return passwordTxtField.isDisplayed();
	}
	public boolean isLoginBtnDisplayed() {
		return loginbtn.isDisplayed();
	}
	public boolean isLoginLogoesDisplayed() {
		for(int i=0;i<loginlogo.size();i++) {
			if(!loginlogo.get(i).isDisplayed()) {
				return false;
			}
		}
		return true;
	}
	public void enterUserName() {
		userNameTxtField.sendKeys("standard_user");
	}
	public void enterpsw() {
		passwordTxtField.sendKeys("secret_sauce");
	}
	public void clickOnLoginbtn() {
		loginbtn.click();
	}


}




