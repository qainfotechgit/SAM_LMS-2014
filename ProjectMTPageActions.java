package com.qait.mindtapintegration.actions;

import com.qait.samintegration.actions.BaseFixture;
import com.qait.util.PropFileHandler;
import com.qait.util.Sikuli;

public class ProjectMTPageActions extends BaseFixture {

	public boolean clickOnProject(String project) {
		return prjPage.clickOnProject(project);
	}
	

	public boolean verifyAssignment()
	{
		String assignment = PropFileHandler.readProperty("MTProjectName");
		return prjPage.verifyAssignment(assignment);
	}
	
	public boolean verifyInstructions()
	{
		return prjPage.verifyInstructions();
	}
	
	public boolean verifyProjectDetails()
	{
		return prjPage.verifyProjectDetails();
	}
	
	public boolean clickOnOkButton()
	{
		return prjPage.clickOnOkButton();
	}
	
	public boolean verifyNumberOfSubmissionsAllowed()
	{
		return prjPage.verifyNumberOfSubmissionsAllowed();
	}
	
	
	public boolean verifyNumberOfSubmissionsRemaining()
	{
		return prjPage.verifyNumberOfSubmissionsRemaining();
	}
	
	
	
	public boolean uploadFile()
	{
		return prjPage.uploadFile();
	}
	
	public boolean clickOnSubmitButton()
	{
		return prjPage.clickOnSubmitButton();
	}
	
	public boolean clickOnAlert()
	{
		return prjPage.clickOnAlert();
	}
	
	public boolean closeActivity() throws InterruptedException
	{
		return prjPage.closeActivity();
	}
	
	public boolean clickOnDownloadLink() throws InterruptedException
	{
		return prjPage.clickOnDownloadLink();
	}
	
	public boolean verifyMarksObtained() throws InterruptedException
	{
		return prjPage.verifyMarksObtained();
	}
	
	
}
