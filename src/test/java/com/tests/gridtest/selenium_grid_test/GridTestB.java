package com.tests.gridtest.selenium_grid_test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GridTestB {
	SoftAssert soft = new SoftAssert();
	String nodeUrl, siteUrl;
	WebDriver driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		siteUrl = "https://www.facebook.com";
		nodeUrl = "http://172.25.96.1:4444/wd/hub";
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		
		driver= new RemoteWebDriver(new URL(nodeUrl),cap);
	}

	@Test
	public void loadAmazonHomePageTest() {
		driver.get(siteUrl);
		soft.assertEquals(siteUrl,driver.getCurrentUrl());
	}
	
//	@AfterTest
//	private void afterTeest() {
//		driver.quit();
//		soft=null;
//	}
}
