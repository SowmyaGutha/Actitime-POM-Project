package com.actitime.qa.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.actitime.qa.util.UtilClass;



public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;

	public BaseClass() {

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"J:/POM/Actitime POM/src/main/java/com/actitime" + "/qa/config/config.properties");
			prop.load(fis);
			System.out.println("Feching the information from Config file");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization()
	{
		String browserName= prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","J:/POM/Exe/chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Chrome browser is initiated");
			
		}else if(browserName.equalsIgnoreCase("firefox"))
		{
			 System.setProperty("webdriver.gecko.driver","J:/POM/Exe/geckodriver.exe");
			//System.setProperty("webdriver.gecko.driver" , "/POM/Exe/geckodriver");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(UtilClass.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(UtilClass.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
