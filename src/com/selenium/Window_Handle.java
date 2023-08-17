package com.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Window_Handle {

	public static void main(String[] args) throws AWTException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".\\WebDriver\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.get("https://www.flipkart.com/");
	
		Thread.sleep(3000);
		
		Actions act = new Actions(wd);
		Robot rob = new Robot();
		
		WebElement mobileClick = wd.findElement(By.xpath("//img[@alt='Mobiles']"));
		act.contextClick(mobileClick).build().perform();
		rob.keyPress(KeyEvent.VK_DOWN);
		rob.keyRelease(KeyEvent.VK_DOWN);
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		
		WebElement appliancesClick = wd.findElement(By.xpath("//img[@alt='Appliances']"));
		act.contextClick(appliancesClick).build().perform();
		rob.keyPress(KeyEvent.VK_DOWN);
		rob.keyRelease(KeyEvent.VK_DOWN);
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		
		WebElement travelClick = wd.findElement(By.xpath("//img[@alt='Travel']"));
		act.contextClick(travelClick).build().perform();
		rob.keyPress(KeyEvent.VK_DOWN);
		rob.keyRelease(KeyEvent.VK_DOWN);
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		
		String mainPage = wd.getWindowHandle();
		
		Set<String> windows = wd.getWindowHandles();
		
		for (String newTab : windows) {
			Thread.sleep(1000);
			if(!newTab.equals(mainPage)) {
				if(wd.switchTo().window(newTab).getCurrentUrl().contains("appliances")) {
					wd.switchTo().window(newTab);
					break;
				}
			}
		}

	}

}
