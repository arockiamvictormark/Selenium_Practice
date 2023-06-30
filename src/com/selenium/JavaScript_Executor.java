package com.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript_Executor {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", ".\\WebDriver\\chromedriver.exe");
		WebDriver wd= new ChromeDriver();
//		wd.get("https://www.amazon.in/");
		wd.get("https://www.vev.design/blog/horizontal-scrolling-website/");	// List of horizontal scrolling websites.
//		wd.get("https://audentodigital.com/");
//		wd.get("https://thelaartbox.com/");
		wd.get("https://www.mirrows.co/home/");
//		wd.get("https://days.christou1910.com/en/");
//		wd.get("https://vvv.vev.site/little-pricks_70947");
//		wd.manage().window().maximize();
		
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) wd;
		js.executeScript("window.scrollBy(0,1000)");
//		js.executeScript("window.scrollBy(500,0)");
		
		System.out.println("------------------------------------------->End of code");
		
	}

}
