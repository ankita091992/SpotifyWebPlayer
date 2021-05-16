package com.spotify.qa.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.spotify.qa.base.TestBase;
import com.spotify.qa.pages.HomePage;
import com.spotify.qa.pages.HomePageAfterLogin;
import com.spotify.qa.pages.LoginPage;
import com.spotify.qa.pages.SearchPage;
import com.spotify.qa.util.TestUtil;

public class SearchPageTest extends TestBase {

	final static Logger logger = Logger.getLogger(SearchPageTest.class);
	private HomePage homepage;
	private LoginPage loginpage;
	private HomePageAfterLogin ahomepage;

	private SearchPage search;

	public SearchPageTest() {

		super();
	}
	
	@Test(priority = 1)
	public void validatePausethesong() {
		logger.info("Checking if the User is able to pause the song from the media player ");
		logger.info("Typing in the name of the playlist");
		search.typeinSearchBox();
		logger.info("Clicking on the playlist");
		search.clickonplaylist();
		logger.info("Clicking on the Song button inside the playlist");
		search.clickonSonginPlaylist();
		logger.info("Clicking on the Close Icon the Cookie Policy popup");
		search.clickonClose();
		logger.info("Pausing the song from the media player");
		search.playorpausetheSong();
		logger.info("Verifying if the song is paused");
		String pauseValue = search.playPausegettoolTipValue();
		System.out.println(pauseValue);
		Assert.assertEquals("Play", pauseValue, "The song is still in play mode");

	}

	@Test(priority = 2)
	public void validatePlaythesongagain() {

		logger.info("Checking if the User is able to play the song again from the media player");
		logger.info("Typing in the name of the playlist");
        search.typeinSearchBox();
		logger.info("Clicking on the playlist");
		search.clickonplaylist();
		logger.info("Clicking on the Song button inside the playlist");
		search.clickonSonginPlaylist();
		logger.info("Clicking on the Close Icon the Cookie Policy popup");
		search.clickonClose();
		logger.info("Pausing the song from the media player ");
		search.playorpausetheSong();
		logger.info("Playing the song from the media player");
		search.playorpausetheSong();
		logger.info("Verifying if the song is played");
		String playValue = search.playPausegettoolTipValue();
		System.out.println(playValue);
		Assert.assertEquals("Pause", playValue, "The song is still in pause mode");

	}


	
		@Test(priority = 3)
	public void validateWhenRepeatnotenabled() {

		logger.info("Checking if the Enable Repeat Icon is in disabled mode or not ");
		logger.info("Typing in the name of the playlist");
        search.typeinSearchBox();
		logger.info("Clicking on the playlist");
		search.clickonplaylist();
		logger.info("Clicking on the Song button inside the playlist");
		search.clickonSonginPlaylist();
		logger.info("Clicking on the Close Icon the Cookie Policy popup");
		search.clickonClose();
		logger.info("Pausing the song from the media player ");
		search.playorpausetheSong();
		logger.info("Verifying the status of the looping icon");
		String notEnabled = search.enableRepeatgettoolTipValue();
		Assert.assertEquals("Enable repeat", notEnabled, "The enable repeat option is not disabled");

	}
		
		@Test(priority = 4)
		public void validateWhenRepeatSongenabled() {

			logger.info("Checking if the Enable Repeat Icon is in song repeat mode  or not ");
			logger.info("Typing in the name of the playlist");
	        search.typeinSearchBox();
			logger.info("Clicking on the playlist");
			search.clickonplaylist();
			logger.info("Clicking on the Song button inside the playlist");
			search.clickonSonginPlaylist();
			logger.info("Clicking on the Close Icon the Cookie Policy popup");
			search.clickonClose();
			logger.info("Pausing the song from the media player ");
			search.playorpausetheSong();
			logger.info("Verifying the status of the looping icon");
			search.enableRepeatonSong();
			String notEnabled = search.enableRepeatgettoolTipValue();
			System.out.println(notEnabled);
			Assert.assertEquals("Enable repeat one", notEnabled, "The enable repeat  option is not enabled for the song");

		}

		@Test(priority = 5)
		public void validateWhenRepeatPlaylistenabled() {

			logger.info("Checking if the Enable Repeat Icon is in playlist repeat mode  or not ");
			logger.info("Typing in the name of the playlist");
	        search.typeinSearchBox();
			logger.info("Clicking on the playlist");
			search.clickonplaylist();
			logger.info("Clicking on the Song button inside the playlist");
			search.clickonSonginPlaylist();
			logger.info("Clicking on the Close Icon the Cookie Policy popup");
			search.clickonClose();
			logger.info("Pausing the song from the media player ");
			search.playorpausetheSong();
			logger.info("Verifying the status of the looping icon");
			search.enableRepeatonSong();
			String notEnabled = search.enableRepeatgettoolTipValue();
			System.out.println(notEnabled);
			Assert.assertEquals("Disable repeat", notEnabled, "The enable repeat option is not disabled");

		}

		@Test(priority = 6)
		public void validateDisablingRepeatagain() {

			logger.info("Checking if the Enable Repeat Icon is in Disabling repeat mode  or not ");
			logger.info("Typing in the name of the playlist");
	        search.typeinSearchBox();
			logger.info("Clicking on the playlist");
			search.clickonplaylist();
			logger.info("Clicking on the Song button inside the playlist");
			search.clickonSonginPlaylist();
			logger.info("Clicking on the Close Icon the Cookie Policy popup");
			search.clickonClose();
			logger.info("Pausing the song from the media player ");
			search.playorpausetheSong();
			logger.info("Verifying the status of the looping icon");
			search.enableRepeatonSong();
			String notEnabled = search.enableRepeatgettoolTipValue();
			System.out.println(notEnabled);
			Assert.assertEquals("Enable repeat", notEnabled, "The enable repeat  option is not enabled for the playlist");

		}

			
		@Test(priority = 7)
		public void validateNextBtn() {

			logger.info("Checking if the next song is played or not ");
			logger.info("Typing in the name of the playlist");
	        search.typeinSearchBox();
			logger.info("Clicking on the playlist");
			search.clickonplaylist();
			logger.info("Clicking on the Song button inside the playlist");
			search.clickonSonginPlaylist();
			String currentSong = search.getSongName();
			logger.info("Clicking on the Close Icon the Cookie Policy popup");
			search.clickonClose();
			logger.info("Pausing the song from the media player ");
			search.playorpausetheSong();
			logger.info("Clicking on the Next button");
			search.clickOnNextBtn();
			logger.info("Verifying if next song is played");
			String nextSong = search.getSongName();
			Assert.assertNotEquals(nextSong, currentSong, "The next song is not as expected");

		}


		@Test(priority = 8)
		public void validatePreviousBtn() {

			logger.info("Checking if the next song is played or not ");
			logger.info("Typing in the name of the playlist");
	        search.typeinSearchBox();
			logger.info("Clicking on the playlist");
			search.clickonplaylist();
			logger.info("Clicking on the Play button at the beginning of the playlist");
			search.clickonSong();
			String currentSong = search.getSongName();
			logger.info("Clicking on the Close Icon the Cookie Policy popup");
			search.clickonClose();
			logger.info("Pausing the song from the media player ");
			search.playorpausetheSong();
			logger.info("Clicking on the previous button");
			search.clickOnPreviousBtn();
			search.clickOnPreviousBtn();
			logger.info("Verifying if previous song is played");
			String previousSong = search.getSongName();
			Assert.assertNotEquals(previousSong, currentSong, "The previous song is not as expected");

		}


		
	
	@BeforeMethod
	public void setUp() {
		initialisation();
		homepage = new HomePage();
		loginpage = homepage.clickOnLoginBtn();
		ahomepage = new HomePageAfterLogin();
		ahomepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		search = new SearchPage();
		search = ahomepage.clickonSearch();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
