package com.qa.testcase;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Exceldata.DataReader;
import com.qa.base.Testbase;
import com.qa.pages.LoginPage;

public class LoginPageTest extends Testbase {
	LoginPage loginPage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage=new LoginPage();
		}
	@Test(priority=1)
	public void To_Verify_the_valid_Url()
	{
		String title= loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Admin area demo");
		
	}
	@DataProvider
	public Iterator<Object[]> gettestdata()
	{
		ArrayList<Object[]>testdata=DataReader.getdataExcel();
		return testdata.iterator();
	}
	@Test(priority=2,dataProvider = "gettestdata")
	public void To_Verify_the_valid_Login(String username,String password)
	{
		loginPage.login(username, password);
		Assert.assertEquals("Employee Distribution by Submit",driver.findElement(By.xpath("//*[@id='panel_resizable_0_4']/div[1]")).getText() );
	}
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
}