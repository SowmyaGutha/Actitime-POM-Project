package com.actitime.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.qa.baseclass.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(id="username")
	WebElement name;

	@FindBy(name="pwd")
	WebElement password;

	@FindBy(id="loginButton")
	WebElement loginButton;

	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String verifyTitle() {
		return driver.getTitle();
	}

	public void login(String un, String pwd) throws InterruptedException {
		try{
		
		name.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		Thread.sleep(2000);
		}catch (Exception e) {
		e.printStackTrace();
		}
	}

}
