package com.qa.Exceldata;

import java.util.ArrayList;

import com.qa.testdata.ExelReader;

public class DataReader {
	static  ExelReader Reader;
	public static ArrayList<Object[]> getdataExcel()
	{
		ArrayList<Object[]> mydata=new ArrayList<Object[]>();
		try
		{
			Reader= new ExelReader("E:\\Java Workplace\\Testautomationdemo\\src\\main\\java\\com\\qa\\testdata\\ExcelUtil.xlsx");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		for(int rowno=2;rowno<=Reader.getRowCount("Sheet1");rowno++)
		{
			String username=Reader.getCellData("Sheet1", "username", rowno);
			String password=Reader.getCellData("Sheet1", "password", rowno);
			Object ob[]= {username,password};
			mydata.add(ob);
		}
		return mydata;
	}




}
