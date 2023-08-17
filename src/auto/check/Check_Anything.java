package auto.check;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Check_Anything {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", ".\\WebDriver\\chromedriver.exe");
		WebDriver wd= new ChromeDriver();
		wd.get("https://www.myntra.com/men-casual-shirts");
		
		List<WebElement> productCount = wd.findElements(By.xpath("//li[@class='product-base']"));
		System.out.println("productCount: "+productCount.size());

	}

}
