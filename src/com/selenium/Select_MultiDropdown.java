package com.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Select_MultiDropdown {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", ".\\WebDriver\\chromedriver.exe");
		WebDriver wd= new ChromeDriver();
		wd.get("https://demoqa.com/select-menu");	
		wd.manage().window().maximize();
		
		WebElement multiSelect = wd.findElement(By.id("cars"));
		Select ms = new Select(multiSelect);
		boolean multiple = ms.isMultiple();
		System.out.println("Multi dropdown?: "+multiple);
		System.out.println("==========================");
		List<WebElement> options = ms.getOptions();
		for (WebElement allOpt : options) {
			System.out.println(allOpt.getText());
		}
		System.out.println("==========================");
		ms.selectByValue("audi");
		ms.selectByIndex(1);
		ms.selectByVisibleText("Opel");
		
		List<WebElement> allSelectedOptions = ms.getAllSelectedOptions();
		for (WebElement allSelOpt : allSelectedOptions) {
			System.out.println(allSelOpt.getText());
		}
		System.out.println("==========================");
		WebElement firstSelectedOption = ms.getFirstSelectedOption();
		System.out.println(firstSelectedOption.getText());
		System.out.println("==========================");
		ms.deselectByValue("saab");
		ms.deselectByIndex(3);
		ms.deselectByVisibleText("Opel");
		
		List<WebElement> allSelectedOptions2 = ms.getAllSelectedOptions();
		for (WebElement allSelOpt2 : allSelectedOptions2) {
			System.out.println(allSelOpt2);
		}

	}

}
