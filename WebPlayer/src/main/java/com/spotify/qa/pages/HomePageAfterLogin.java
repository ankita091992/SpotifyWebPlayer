package com.spotify.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.spotify.qa.base.TestBase;
import com.spotify.qa.util.TestUtil;

public class HomePageAfterLogin extends TestBase {

//	Page Factory--OR

	@FindBy(xpath = "//*[@href='/search']")
	private WebElement searchmenu;

//	Initializing the Page objects	
	public HomePageAfterLogin() {

		PageFactory.initElements(driver, this);
	}

//	Actions:

	public SearchPage clickonSearch() {

		searchmenu.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		return new SearchPage();

	}

}
