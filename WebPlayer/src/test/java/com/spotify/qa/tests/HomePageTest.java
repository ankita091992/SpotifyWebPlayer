package com.spotify.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.spotify.qa.base.TestBase;
import com.spotify.qa.pages.HomePage;
import com.spotify.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	HomePage homepage;
	LoginPage loginpage;
	
	public HomePageTest() {
		super();
	}
	
	
	@Test(priority=1)
	public void homePageTitleTest() {
		String actualhomePageTitle=homepage.verifyHomePageTitle();
		Assert.assertEquals(actualhomePageTitle, "Spotify - Web Player: Music for everyone");
		
	}
	
	
	@Test(priority=2)
	public void loginbuttonclickTest() {
	
		loginpage=homepage.clickOnLoginBtn();
		
		
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialisation();
		homepage=new HomePage();
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

}
