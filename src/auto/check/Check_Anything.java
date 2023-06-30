package auto.check;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Check_Anything {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".\\WebDriver\\chromedriver.exe");
		WebDriver wd= new ChromeDriver();
//		System.setProperty("webdriver.gecko.driver", ".\\WebDriver\\geckodriver.exe");
//		WebDriver wd= new FirefoxDriver();
//		System.setProperty("webdriver.edge.driver", ".\\WebDriver\\msedgedriver.exe");
//		WebDriver wd= new EdgeDriver();
		wd.get("https://www.gmail.com/");
		
		WebElement email = wd.findElement(By.id("identifierId"));
		email.sendKeys("arockiamvictormark");
		WebElement clickNext = wd.findElement(By.xpath("//span[text()='Next']"));
		clickNext.click();

	}

}
