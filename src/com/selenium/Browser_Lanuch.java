package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser_Lanuch {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", ".\\WebDriver\\chromedriver.exe");

		WebDriver wd= new ChromeDriver();
		wd.get("https://www.amazon.in/");	
		wd.manage().window().maximize();

	}

}
