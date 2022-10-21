package pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Parametrization;

public class SwagLabLoginPage {
	
	@FindBy(xpath ="//input[@id='user-name']") private WebElement userId;
	@FindBy(xpath ="//input[@id='password']") private WebElement password;
	@FindBy(xpath ="//input[@id='login-button']") private WebElement logIn;
	@FindBy(xpath ="//h3[@data-test='error']") private WebElement errorMSG;
	@FindBy(xpath ="//h4[normalize-space( )='Accepted usernames are:']") private WebElement Data;
	
	public SwagLabLoginPage (WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	
	public void enterUserId(int row, int cell) throws EncryptedDocumentException, IOException {
	  userId.sendKeys(Parametrization.getExcelData(row, cell, "Credential"));
	}
	
	public void enterPass(int row, int cell) throws EncryptedDocumentException, IOException {
		password.sendKeys(Parametrization.getExcelData(row, cell, "Credential"));
	}
	public void clickLogin() {
		logIn.click();
	}
	
	public String gotErrorMSG() {
		String error1 = errorMSG.getText();
		return error1;
	}
	
	public String gotDataText() {
		String data1 = Data.getText();
		return data1;
	}
	

}
