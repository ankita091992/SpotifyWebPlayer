package com.spotify.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.spotify.qa.base.TestBase;

public class LoginPage extends TestBase {

//	Page Factory-OR

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "remember")
	WebElement rememberMe;

	@FindBy(id = "login-button")
	WebElement login;

//	Initializing the Page objects	
	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

//	Actions

	public String validateloginPageTitle() {
		return driver.getTitle();
	}

	public HomePageAfterLogin login(String un, String pwd) {

		username.sendKeys(un);
		password.sendKeys(pwd);

		login.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return new HomePageAfterLogin();

	}

}
