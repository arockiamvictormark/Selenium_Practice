package com.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Flipkart_Task {

	public static void main(String[] args) throws AWTException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".\\WebDriver\\chromedriver.exe");
		WebDriver wd= new ChromeDriver();
		
// 1. Navigate to the given URL
		wd.get("https://www.flipkart.com/");
		wd.manage().window().maximize();
		
// 2. Close the Login Modal Screen
		WebElement loginModal = wd.findElement(By.xpath("/html/body/div[2]/div/div/button"));
		loginModal.click();
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		Actions act = new Actions(wd);
		
// 3. Hover the Menu Electronics --> MI Link
		WebElement moveToElectronics = wd.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[4]/a/div[2]/div/div"));
		act.moveToElement(moveToElectronics).build().perform();		
		WebElement moveToElectronicsAll = wd.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[4]/a/div[2]/div[2]/div[2]/div/div/div[2]/a[1]"));
		act.moveToElement(moveToElectronicsAll).build().perform();		
		moveToElectronicsAll.click();		
		WebElement moveToElec = wd.findElement(By.xpath("/html/body/div/div/div[2]/div/div/span[1]"));
		act.moveToElement(moveToElec).build().perform();		
		WebElement mi = wd.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[1]/a[2]"));
		act.moveToElement(mi).build().perform();		
		mi.click();
		
// 4. Verify "Latest from MI"
		WebElement newestFirst = wd.findElement(By.xpath("/html/body/div/div/div[3]/div[1]/div[2]/div[1]/div/div/div[3]/div[4]"));
		newestFirst.click();
		
// 5. Change the price slider
		WebElement priceSlide = wd.findElement(By.xpath("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]/div[1]/div"));
		act.dragAndDropBy(priceSlide, 50, 0).build().perform();
		
// 6. Choose the third option from the max dropdown
		WebElement selectMaxPrice = wd.findElement(By.xpath("/html/body/div/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[4]/div[3]/select"));
		Select sel = new Select(selectMaxPrice);
		sel.selectByIndex(2);
		
// 7. Search for "redmi go (black, 8 gb)" in the search bar
		WebElement searchBar = wd.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input"));
		searchBar.sendKeys("redmi A1 (black, 32 gb)");
//		searchBar.sendKeys("redmi go (black, 8 gb)");
		WebElement search = wd.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/div[2]/div[2]/form/div/button"));
		search.click();
		
// 8. Click the first product displayed on the screen
		WebElement firstProduct = wd.findElement(By.xpath("/html/body/div/div/div[3]/div[1]/div[2]/div[2]//descendant::div[contains(text(),'GB)')]"));
//		WebElement firstProduct = wd.findElement(By.xpath("/html/body/div/div/div[3]/div[1]/div[2]/div[2]//descendant::div[contains(text(),'8 GB')]"));
		firstProduct.click();
		
// 9. Verify that the product amount should be greater than or equal to 0
		String mainPage = wd.getWindowHandle();		
		Set<String> windows = wd.getWindowHandles();		
		for (String newTab : windows) {
			if(!newTab.equals(mainPage)) {
				if(wd.switchTo().window(newTab).getCurrentUrl().contains("redmi-a1-black-32-gb")) {
//				if(wd.switchTo().window(newTab).getCurrentUrl().contains("redmi-go-black-8-gb")) {
					wd.switchTo().window(newTab);
					break;
				}
			}
		}
		WebElement productPrice = wd.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div[2]//descendant::div[contains(text(),'₹')]//preceding-sibling::div"));
//		WebElement productPrice = wd.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div[2]//descendant::div[contains(text(),'₹')]"));
		String replaceSymbol = productPrice.getText().replace("₹", "");
		String replaceComma = replaceSymbol.replace(",", "");
		int prodAmt = Integer.parseInt(replaceComma);
		if(prodAmt>0)
				System.out.println("Product Amount is greater than 0: "+prodAmt);
		
// 10. Click on the image thumbnail which displays play video icon (use IFrame)
//		WebElement sideIcon = wd.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div[1]/div/div[1]/div[1]/div/div[1]/ul/li[2]"));
//		sideIcon.click();
//		WebElement mainFrame = wd.findElement(By.xpath("//iframe[contains(@src,'youtube')]"));
//		wd.switchTo().frame(mainFrame);
//		WebElement playButton = wd.findElement(By.xpath("/html/body/div/div/div[4]/button"));
//		playButton.click();
//		wd.switchTo().defaultContent();
		
		
// 11. Enter the Delivery pincode by keboard event (Use keyboard event)
		WebElement enterPincode = wd.findElement(By.xpath("//input[@placeholder='Enter Delivery Pincode']"));
		act.click(enterPincode).build().perform();

		Robot rob = new Robot();
		rob.keyPress(KeyEvent.VK_6);
		rob.keyRelease(KeyEvent.VK_6);
		rob.keyPress(KeyEvent.VK_0);
		rob.keyRelease(KeyEvent.VK_0);
		rob.keyPress(KeyEvent.VK_0);
		rob.keyRelease(KeyEvent.VK_0);
		rob.keyPress(KeyEvent.VK_0);
		rob.keyRelease(KeyEvent.VK_0);
		rob.keyPress(KeyEvent.VK_4);
		rob.keyRelease(KeyEvent.VK_4);
		rob.keyPress(KeyEvent.VK_1);
		rob.keyRelease(KeyEvent.VK_1);
		
		wd.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div[7]/div/div/div[1]/div[2]/div/div[2]/div[1]/span")).click();
		Thread.sleep(3000);
		
// 12. Click on the "View Details" link under Delivery pincode
		WebElement viewDetails = wd.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div[7]/div/div/div[2]/div[2]/span"));
		viewDetails.click();
		WebElement closeDetails = wd.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/button"));
		closeDetails.click();
		
// 13. Click on "Add To Cart"
		WebElement addToCart = wd.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button"));
		addToCart.click();
		
// 14. Close the browser
//		wd.quit();

	}

}
