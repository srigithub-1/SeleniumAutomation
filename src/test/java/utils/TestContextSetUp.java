package utils;

import java.io.IOException;

import pageObjects.PageObjectManager;

//Create the constructor class

public class TestContextSetUp
{
	//Define instance of PageObjectManager, TestBase and GenericUtils
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;

	//Define the behaviour of TestContextSetUp constructor
	public TestContextSetUp() throws IOException
	{
		//Create objects of PageObjectManager, TestBase and GenericUtils
		testBase = new TestBase();
		pageObjectManager = new PageObjectManager();
		genericUtils = new GenericUtils(testBase.WebDriverManager());

	}
}
