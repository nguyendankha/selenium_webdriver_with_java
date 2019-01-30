package Basic;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Iterator;
import java.util.List;

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
	
	@Test
	public void findMultipleElementsOnPage() {
		String inputXpath = "//input";
		By allInputElements = By.xpath(inputXpath);
		List<WebElement> listOfInput =  driver.findElements(allInputElements);
		if (listOfInput.size() != 0) {
			for (Iterator iterator = listOfInput.iterator(); iterator.hasNext();) {
				WebElement webElement = (WebElement) iterator.next();
				System.out.println(webElement.getAttribute("class"));
			}
		} else {
			System.out.println("Not found any item!!!");
		}
	}

	@AfterClass
	public void afterClass() {
		driver.close();
		driver.quit();
	}

}
