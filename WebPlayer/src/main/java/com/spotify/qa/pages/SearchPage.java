package com.spotify.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.spotify.qa.base.TestBase;
import com.spotify.qa.util.TestUtil;

public class SearchPage extends TestBase {

//	Page factory-OR

	@FindBy(xpath = "//*[@id='main']/div/div[2]/div[1]/header/div[3]/div/div/input")
	WebElement searchbox;

	@FindBy(xpath = "//div[@class='e7c3d1a9189832a9f2cbe80dfdf503f5-scss']/a")
	WebElement playlist;

	@FindBy(xpath = "//*[@id='main']/div/div[2]/div[3]/main/div[2]/div[2]/div/div/div[2]/section/div[2]/div[2]/div/button[1]")
	WebElement playbutton;

	@FindBy(xpath = "//*[@id='onetrust-close-btn-container']/button")
	WebElement close;

	@FindBy(xpath = "//*[@id='main']/div/div[2]/div[2]/footer/div/div[2]/div/div[1]/button[3]")
	WebElement playPauseBtn;
	
	@FindBy(xpath = "//*[@id='main']/div/div[2]/div[2]/footer/div/div[2]/div/div[1]/button[5]")
	WebElement enableRepeat;
	
	@FindBy(xpath = "//*[@id='main']/div/div[2]/div[2]/footer/div/div[2]/div/div[1]/button[2]")
	WebElement previousBtn; 
	
	@FindBy(xpath = "//*[@id='main']/div/div[2]/div[2]/footer/div/div[2]/div/div[1]/button[4]")
	WebElement nextBtn; 
	
	@FindBy(xpath = "//*[@id='main']/div/div[2]/div[2]/footer/div/div[1]/div/div[2]/div[1]/span/a")
	WebElement songName;

//	Initializing the Page objects
	public SearchPage() {

		PageFactory.initElements(driver, this);
	}

//	Actions

	public void typeinSearchBox() {

		searchbox.sendKeys(TestUtil.SEARCH_ITEM);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(playlist));

	}

	public void clickonplaylist() {
		playlist.click();

	}

	public void clickonSong() {
		playbutton.click();

	}

	public void clickonClose() {
		close.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(playPauseBtn));

	}

	public void playorpausetheSong() {
		
		Actions action=new Actions(driver);
		action.moveToElement(playPauseBtn).perform();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		playPauseBtn.click();
		

	}

	
	public String playPausegettoolTipValue() {
		String toolTipValue = playPauseBtn.getAttribute("title");
		return toolTipValue;

	}
	
	public void enableRepeatonSong() {
		Actions action=new Actions(driver);
		action.moveToElement(enableRepeat).perform();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		enableRepeat.click();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String enableRepeatgettoolTipValue() {
		String toolTipValue = enableRepeat.getAttribute("title");
		return toolTipValue;

	}
	
	public void clickOnPreviousBtn() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(previousBtn));
		Actions action=new Actions(driver);
		action.moveToElement(previousBtn).perform();
		previousBtn.click();
		
		
	}
	
	public void clickOnNextBtn() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(nextBtn));
		Actions action=new Actions(driver);
		action.moveToElement(nextBtn).perform();
		nextBtn.click();
		
		
	}
	
	public String getSongName() {
		Actions action=new Actions(driver);
		action.moveToElement(enableRepeat).perform();
		String getSongName=songName.getText();
		return getSongName;
		
	}
}
