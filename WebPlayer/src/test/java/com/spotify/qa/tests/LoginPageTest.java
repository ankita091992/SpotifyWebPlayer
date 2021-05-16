package com.spotify.qa.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.spotify.qa.base.TestBase;
import com.spotify.qa.pages.HomePage;
import com.spotify.qa.pages.HomePageAfterLogin;
import com.spotify.qa.pages.LoginPage;
import com.spotify.qa.util.TestUtil;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	HomePageAfterLogin ahomepage;

	public LoginPageTest() {

		super();
	}

	
	@Test(priority = 1)
	public void validateLoginTest() {

		String title = loginpage.validateloginPageTitle();
        Assert.assertEquals(title, "Login - Spotify");
          loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
        }

	
	@BeforeMethod
	public void setUp() {
		initialisation();
		homepage = new HomePage();
		loginpage = homepage.clickOnLoginBtn();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() {

		// driver.quit();
	}

}
