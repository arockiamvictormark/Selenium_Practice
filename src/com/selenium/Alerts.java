package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".\\WebDriver\\chromedriver.exe");
		WebDriver wd= new ChromeDriver();
		wd.get("https://demo.automationtesting.in/Alerts.html");	
		wd.manage().window().maximize();
		
		WebElement simpleAlert = wd.findElement(By.xpath("//button[@class='btn btn-danger']"));
		simpleAlert.click();
		wd.switchTo().alert().accept();
		
		WebElement secondAlert = wd.findElement(By.xpath("(//a[@class='analystic'])[2]"));
		secondAlert.click();
		WebElement confirmAlert = wd.findElement(By.xpath("//button[@class='btn btn-primary']"));
		confirmAlert.click();
		wd.switchTo().alert().dismiss();
		
		WebElement thirdAlert = wd.findElement(By.xpath("(//a[@class='analystic'])[3]"));
		thirdAlert.click();
		WebElement promptAlert = wd.findElement(By.xpath("//button[@class='btn btn-info']"));
		promptAlert.click();		
		String promptMsg = wd.switchTo().alert().getText();		
		System.out.println("promptMsg: "+promptMsg);		
		wd.switchTo().alert().sendKeys("Victor");		
		wd.switchTo().alert().accept();
		WebElement msg = wd.findElement(By.xpath("//p[@id='demo1']"));
		String promptTxt = msg.getText();
		System.out.println("promptTxt: "+promptTxt);

	}

}
