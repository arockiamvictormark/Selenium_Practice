package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", ".\\WebDriver\\chromedriver.exe");
		WebDriver wd= new ChromeDriver();
		wd.get("https://demo.automationtesting.in/Frames.html");	
		wd.manage().window().maximize();
		
		wd.switchTo().frame("singleframe");
		WebElement inputText = wd.findElement(By.xpath("(//input[@type='text'])[1]"));
		inputText.sendKeys("Victor");
		
		wd.switchTo().defaultContent();
		
		WebElement multiFrame = wd.findElement(By.xpath("//a[text()='Iframe with in an Iframe']"));
		multiFrame.click();
		
		WebElement parentFrame = wd.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		wd.switchTo().frame(parentFrame);
		WebElement singleFrame = wd.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
		wd.switchTo().frame(singleFrame);
		WebElement multiText = wd.findElement(By.xpath("//input[@type='text']"));
		multiText.sendKeys("Mark");

	}

}
