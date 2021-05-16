package com.spotify.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.spotify.qa.base.TestBase;

public class HomePage extends TestBase {

//	PageFactory-OR
	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	WebElement LoginBtn;

//	Initializing the Page objects
	public HomePage() {

		PageFactory.initElements(driver, this);
	}

//	Actions:

	public String verifyHomePageTitle() {

		return driver.getTitle();

	}

	public LoginPage clickOnLoginBtn() {
		System.out.println(LoginBtn.getText());
		LoginBtn.click();

		System.out.println("HomePage.clickOnLoginBtn()");
		return new LoginPage();

	}

}
