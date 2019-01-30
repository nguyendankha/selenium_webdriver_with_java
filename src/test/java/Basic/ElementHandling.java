package Basic;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class ElementHandling {
	WebDriver driver;
	String testingURL = "http://demo-store.seleniumacademy.com/";
	String userDir = System.getProperty("user.dir");
	String chromeDriverPath = userDir.concat("\\src\\test\\java\\driver\\chromedriver.exe");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		driver.get(testingURL);
	}

	@Test
	public void findElementOnPage() {
		By searchInput = By.id("search");
		WebElement searchElement = driver.findElement(searchInput);
		if (searchElement.isDisplayed() == true) {
			System.out.println("Search box is displayed");
		} else {
			System.out.println("Search box is NOT displayed");
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
