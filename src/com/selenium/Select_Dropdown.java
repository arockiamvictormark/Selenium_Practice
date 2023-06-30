package com.selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Select_Dropdown {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", ".\\WebDriver\\chromedriver.exe");
		WebDriver wd= new ChromeDriver();
		wd.get("https://www.facebook.com/");	
		wd.manage().window().maximize();
		
		WebElement createAccount = wd.findElement(By.xpath("//a[text()='Create new account']"));
		createAccount.click();
		Thread.sleep(2000);
		WebElement firstname = wd.findElement(By.name("firstname"));
		firstname.sendKeys("myfirstname");
		WebElement lastname = wd.findElement(By.name("lastname"));
		lastname.sendKeys("nysurname");
		WebElement email = wd.findElement(By.name("reg_email__"));
		email.sendKeys("myemail@gmail.com");
		Thread.sleep(2000);
		WebElement emailConfirm = wd.findElement(By.name("reg_email_confirmation__"));
		emailConfirm.sendKeys("myemail@gmail.com");
		WebElement pwd = wd.findElement(By.name("reg_passwd__"));
		pwd.sendKeys("mypass");
		WebElement birthDay = wd.findElement(By.id("day"));
		Select bd = new Select(birthDay);
		bd.selectByValue("7");
		WebElement birthMonth = wd.findElement(By.id("month"));
		Select bm = new Select(birthMonth);
		bm.selectByIndex(10);
		WebElement birthYear = wd.findElement(By.id("year"));
		Select by = new Select(birthYear);
		by.selectByVisibleText("1981");
		WebElement gender = wd.findElement(By.xpath("//input[@value=2]"));
		gender.click();
		WebElement signUp = wd.findElement(By.name("websubmit"));
		signUp.click();
		
		TakesScreenshot tss = (TakesScreenshot) wd;		
		File src = tss.getScreenshotAs(OutputType.FILE);
		File des = new File(".\\ScreenShots\\ss1.png");
		FileUtils.copyFile(src, des);

	}

}
