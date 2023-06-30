package com.selenium;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriver_Methods {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", ".\\WebDriver\\chromedriver.exe");

		WebDriver wd= new ChromeDriver();
		wd.get("https://www.amazon.in/");	
		wd.manage().window().maximize();
		
		Point pt = new Point(150,150);
		wd.manage().window().setPosition(pt);
		
		wd.navigate().to("https://www.flipkart.com/");
		wd.navigate().back();
//		wd.navigate().forward();
		wd.navigate().refresh();
		String title = wd.getTitle();
		System.out.println("Title: "+title);
		
		String currentUrl = wd.getCurrentUrl();
		System.out.println("Current URL: "+currentUrl);
		
//		String pageSource = wd.getPageSource();
//		System.out.println("Page Source: "+pageSource);

	}

}
