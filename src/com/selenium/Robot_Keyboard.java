package com.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Robot_Keyboard {

	public static void main(String[] args) throws AWTException {

		System.setProperty("webdriver.chrome.driver", ".\\WebDriver\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.get("https://www.flipkart.com/");
		
		Actions a = new Actions(wd);
		Robot r = new Robot();
		
		WebElement mobileClick = wd.findElement(By.xpath("//img[@alt='Mobiles']"));
		a.contextClick(mobileClick).build().perform();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		WebElement appliancesClick = wd.findElement(By.xpath("//img[@alt='Appliances']"));
		a.contextClick(appliancesClick).build().perform();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		WebElement travelClick = wd.findElement(By.xpath("//img[@alt='Travel']"));
		a.contextClick(travelClick).build().perform();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

}
