package org.StepDefinition;

import org.Factory.DriverFactory;
import org.Utilities.Baseutility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.saucelabTestPages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {
	Baseutility bu=new Baseutility();
	WebDriver driver;
	
	LoginPage lpobj=new LoginPage(DriverFactory.getDriver());
@Given ("user is on login page")
 public void user_is_on_login_page() {
	System.setProperty("webdriver.chrome.driver","C:/Users/LENOVO.T460s/Downloads/chromedriver_win32/chromedriver.exe");
		//WebDriver driver=bu.startup("chromebrowser","https://www.saucedemo.com");
	     driver=new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.manage().deleteAllCookies();
	     driver.navigate().to("https://www.saucedemo.com");
}
@Then("verify username field is displayed")
public void verify_username_field_is_displayed() {
	lpobj.isUserNameFieldDispalyed();
    
}

@Then("verify password field is displayed")
public void verify_password_field_is_displayed() {
    lpobj.isPasswordFieldDisplayed();
}

@Then("verify loginbutton is displayed")
public void verify_loginbutton_is_displayed() {
    lpobj.isLoginBtnDisplayed();
}

@Then("verify loginlogos are displayed")
public void verify_loginlogos_are_displayed() {
    lpobj.isLoginLogoesDisplayed();
}

@When("user enters username")
public void user_enters_username() {
    lpobj.enterUserName();
}

@When("user enters password")
public void user_enters_password() {
	lpobj.enterpsw();
}
    

@When("user click on login button")
public void user_click_on_login_button() {
	lpobj.clickOnLoginbtn();
}
   

@Then("user navigated to the prouct search page")
public void user_navigated_to_the_prouct_search_page() {
  System.out.println("user is on product search page");
}


}
