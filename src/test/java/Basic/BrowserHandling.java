package Basic;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserHandling {
	WebDriver driver;
	String testingURL = "https://chercher.tech";
	String testingNavigateURL = "https://chercher.tech/java/index-selenium-webdriver";
	String currentURL;
	
	@BeforeClass
	public void openBrowser() {
		String workspacePath =  (System.getProperty("user.dir")).concat("\\src\\test\\java\\driver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", workspacePath);
		driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public void navigateURL() {
		driver.get(testingURL);
		System.out.println("Setup done for testing. Open the " + testingURL + " page.");
	}
	
	@Test
	public void navigationMethod() {
		Navigation navigation = driver.navigate();
		navigation.to(testingNavigateURL);
		System.out.println("Navigation to URL: " + testingNavigateURL);
	}
	
	@Test
	public void maximizedBrowserWindow() {
		Options managedWindow = driver.manage();
		Window browserWindow = managedWindow.window();
		browserWindow.maximize();
		System.out.println("Browser size is maximized!!!");
	}
	
	@Test
	public void getTheMaximizedWindowSize() {
		Dimension windowSize = driver.manage().window().getSize();
		int windowSize_Height = windowSize.height;
		int windowSize_Width = windowSize.width;
		System.out.println("The maximized browser window size: ");
		System.out.println("--------------");
		System.out.println("Height: " + windowSize_Height);
		System.out.println("Width: " + windowSize_Width);
		System.out.println("--------------");
	}
	
	@Test
	public void setSizeForWindowBrowser() {
		Dimension newSizeForWindowBrowser = new Dimension(400, 700);
		driver.manage().window().setSize(newSizeForWindowBrowser);
		Dimension windowSizeAfterResized = driver.manage().window().getSize();
		System.out.println("New window browser size: ");
		System.out.println("--------------");
		System.out.println("Height: " + windowSizeAfterResized.getHeight());
		System.out.println("Width: " + windowSizeAfterResized.getWidth());
		System.out.println("--------------");
	}
	
	@Test
	public void refreshBrowser() {
		currentURL = driver.getCurrentUrl();
		System.out.println("URL before refreshing... " + currentURL);
		driver.navigate().refresh();
		currentURL = driver.getCurrentUrl();
		System.out.println("URL after refreshed... " + currentURL);
	}
	
	@Test
	public void getPageTitle() {
		String pageTitle = null;
		driver.navigate().to(testingNavigateURL);
		pageTitle = driver.getTitle();
		System.out.println("Title of page after navigated: " + pageTitle);
		driver.navigate().back();
		pageTitle = driver.getTitle();
		System.out.println("Title of page after back: " + pageTitle);
	}
	
	@AfterClass
	public void teardown() {
		System.out.println("Done testing. Teardown driver.");
		driver.close();
		driver.quit();
	}
}
