package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.utill.TestUtil;

public class Testbase {
	public static WebDriver driver;
	public static Properties prop;

	public Testbase()
	{
		try{
			prop = new Properties();
			FileInputStream ip= new FileInputStream("src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}
	public static void initialization()
	{
		
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		
		/*
		 * String browser = prop.getProperty("browsername");
		 * 
		 * if(browser == "firefox") { driver=new FirefoxDriver();
		 * driver.manage().window().maximize(); } else if(browser == "chrome") {
		 * driver=new ChromeDriver(); driver.manage().window().maximize(); }
		 */
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		driver.get(prop.getProperty("url"));
	}
}
