package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElement_Methods {

	public static void main(String[] args) throws InterruptedException {

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
		WebElement gender = wd.findElement(By.xpath("//input[@value=2]"));
		gender.click();
		WebElement signUp = wd.findElement(By.name("websubmit"));
		signUp.click();

	}

}
