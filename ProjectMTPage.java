package com.qait.mindtapintegration.ui;

import java.io.File;
import java.util.Set;

import javax.xml.xpath.XPath;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.sikuli.script.AppearEvent;

import com.qait.samintegration.actions.BaseFixture;
import com.qait.samintegration.ui.AbstractParentPage;
import com.qait.util.Sikuli;
import com.qait.util.Utilities;

public class ProjectMTPage extends AbstractParentPage {

	private WebDriver driver;
	String winHandleBefore;

	public ProjectMTPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}


		
	@FindBy(xpath="//span[@id='ctl00_ContentPlaceHolder1_lblAssignmentName']")
	private WebElement verifyAssignment;
	
	@FindBy(xpath="//div[contains(text(),'Read each task completely before attempting it.')]")
	private WebElement verifyInstructions;
	
	@FindBy(xpath="(//tr[2]/td)[2]")
	private WebElement verifyProjectDetails;
	
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_imgOk']")
	private WebElement clickOnOkButton;
	
	@FindBy(xpath="//span[@id='ctl00_ContentPlaceHolder1_lblMaximumNumberOfSubmissionStatic']")
	private WebElement verifyNumberOfSubmissionsAllowed;
	
	@FindBy(xpath="//span[@id='ctl00_ContentPlaceHolder1_lblNumberOfSubmissionRemainingStatic']")
	private WebElement verifyNumberOfSubmissionsRemaining;
	
	@FindBy(xpath="//input[@id='ctl00__titleContentplaceholder_BGSControl_submissionFilesGridView_ctl02_fileUpload']")
	private WebElement uploadFile;
	
	@FindBy(xpath="(//td[@class='GridViewItemProjects'])[2]")
	private WebElement fileToBeUploaded;
	
	@FindBy(xpath="//input[@id='ctl00__titleContentplaceholder_BGSControl_btnSubmit']")
	private WebElement clickOnSubmitButton;
	
	@FindBy(xpath="//a[@id='ctl00__titleContentplaceholder_BGSControl_lnkDownload']")
	private WebElement DownloadSolutionLink;
	
//	@FindBy(className="closeActivity")
//	private WebElement closeActivity;
	@FindBy(css="a[class='closeActivity']")
	private WebElement closeActivity;
	
	
	@FindBy(xpath="//div[@class='lpn_score'][contains(text(),'.0%')]")
	private WebElement verifyMarksObtained;
	
	
	static String mainPage;
	static String parentWindowHandle;
	boolean appear;
	
	
	public boolean clickOnProject(String project) {
		

		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle);
		   }
		
		WebElement clickOnProjectLink=driver.findElement(By.xpath(".//a[contains(text(),'"+project+"')]"));
		
		waitForElementToAppear(clickOnProjectLink);
		
		clickOnProjectLink.click();
		
		wait(4000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'NB_Main_IFrame')]")));
		wait(2000);
		
		return true;
	}
	

	public boolean verifyAssignment(String assignment)
	{
		if(verifyAssignment.getText().equals(assignment))
			return true;
		else
			return false;
	}
	
	public boolean verifyInstructions()
	{
		String instructions="Read each task completely before attempting it.";
		if(verifyInstructions.getText().equals(instructions))
			return true;
		else
			return false;
	}
		
	public boolean verifyProjectDetails()
	{
		if(verifyProjectDetails.getText().equals("Project Details:"))
			return true;
		else
			return false;
	}
	
	public boolean clickOnOkButton()
	{
		if(clickOnOkButton.isDisplayed())
			{
			clickOnOkButton.click();
			return true;
			}
		else
			return false;
	}
	
	public boolean verifyNumberOfSubmissionsAllowed()
	{
		if(verifyNumberOfSubmissionsAllowed.isDisplayed())
			return true;
		else
			return false;
	}
	
	public boolean verifyNumberOfSubmissionsRemaining()
	{
		if(verifyNumberOfSubmissionsRemaining.isDisplayed())
			return true;
		else
			return false;
	}
	
	
	public boolean clickOnDownloadLink() throws InterruptedException {
		  String methodName = Thread.currentThread().getStackTrace()[1]
		    .getMethodName(); 
		  waitForForeSeeToAppear();
		  try {
		   DownloadSolutionLink.click();
		   if (BaseFixture.Browser.equals("iexplore")) {
		    Utilities.TriggerAutoItActions("handleWinComponent.exe",
		      "Download", System.getProperty("user.dir")
		        + "\\DownloadAutomation\\");
		    wait(20000);
		   } else if (BaseFixture.Browser.equals("googlechrome")) {
		    Utilities.TriggerAutoItActions("handleWinComponent.exe",
		      "DownloadChrome", System.getProperty("user.dir")
		        + "\\DownloadAutomation\\");
		    Thread.sleep(10000);
		   }
		  } catch (Exception e) {

		  }
		return true;

		 }
	
	public boolean uploadFile()
	{
		wait(5000);
		uploadFile.click();
		wait(5000);
		String methodName = Thread.currentThread().getStackTrace()[1]
			    .getMethodName(); waitForForeSeeToAppear();
			  try {
			   String path = System.getProperty("user.dir")
			     + "\\DownloadAutomation\\";
			   System.out.println("path is " + path);
			   wait(1000);
			   
			   File file = new File(path + fileToBeUploaded.getText());
			   System.out.println("file is" + file.getAbsolutePath());
			   uploadFile.sendKeys(file.getAbsolutePath());
			   System.out.println(uploadFile.getText());
			   return true;
			  } catch (Exception e) {
			   screenShotOnException(methodName);
			   return false;
			  }
	}
	
	public boolean clickOnSubmitButton()
	{
		clickOnSubmitButton.click();
		System.out.println("submit");
		wait(6000);
		return true;
	}
	
	public boolean clickOnAlert()
	{
		try
		{
		driver.switchTo().alert().accept();
		System.out.println("alert");
		wait(6000);
		return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false ;
		}
		
		
	}
	
	public boolean closeActivity() throws InterruptedException
	{
		Thread.sleep(5000);
		System.out.println("close");
		closeActivity.click();
		Thread.sleep(2000);
		
//		System.out.println("close Button");
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("document.getElementsByClassName('closeActivity')[0].click()");
//		System.out.println("done");
		return true;
		
	}
	
	
	public boolean verifyMarksObtained()
	{
		wait(3000);
		int marksToBeObtained=0;
		int marksObtained=Integer.parseInt(verifyMarksObtained.getText());
		if(marksObtained>=marksToBeObtained)
		{
			System.out.println("Marks Retrived");
			return true;
		}
		else
			return false;
	}
	
}
