package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;

public class LoginPage extends Testbase{
	
	@FindBy(id = "Email")
	public static WebElement username;
	
	@FindBy(id = "Password")
	public static WebElement Password;
	
	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement Submit;

	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	public void login(String un,String pwd)
	{
		username.sendKeys(un);
		Password.sendKeys(pwd);
		//Submit.click();
	}
}


