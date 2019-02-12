package com.actitime.qa;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.qa.baseclass.BaseClass;
import com.actitime.qa.pages.LoginPage;

public class LoginPageTest extends BaseClass {

	LoginPage loginpage;

	public LoginPageTest() {
		super();

	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
	}

	@Test(priority = 2)
	public void loginTest() throws InterruptedException {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		String name= driver.getTitle();
		System.out.println("Page Title is: "+  name);
		Assert.assertEquals("actiTIME - Enter Time-Track", name);
		System.out.println("Logged in Successfully");
	}

	@Test(priority = 1)
	public void verifyTitleTest() throws InterruptedException {
		String title = loginpage.verifyTitle();
		System.out.println("Page Title is: " + title);
		Assert.assertEquals("actiTIME - Login", title);
	}

	@Test(priority = 3)
	public void verifyTitleTest1() throws InterruptedException {
		String title = loginpage.verifyTitle();
		System.out.println("Page Title is: " + title);
		Assert.assertEquals("actiTIME - Login", title);
	}

	@AfterMethod
	public void shutdown() {
		driver.quit();
		System.out.println("Browser closed");
	}

}
