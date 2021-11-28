package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;

public class LoginPage extends Testbase{
	@FindBy(xpath="//*[@id=\'txtUsername\']")
	WebElement username;
	@FindBy(xpath="//*[@id='txtPassword']")
	WebElement Password;
	@FindBy(xpath="//*[@id=\'btnLogin\']")
	WebElement Submit;
	
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
	Submit.click();
	
	}
}


