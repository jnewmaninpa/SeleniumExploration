package example.seleniumexploration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public CommonFunctions(String browser, long timeout) {
		if (browser.equalsIgnoreCase("chrome")) {
	    	System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
	        driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
	    	System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
	    	driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("headless")) {
	    	System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
	        driver = new ChromeDriver(options);
		}
		
        driver.manage().window().maximize(); // maximize the window
        wait = new WebDriverWait(driver, timeout);
	}
	
	private WebElement waitUntilVisible(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void navigateToUrl(String url) {
		driver.get(url);
	}
	
	public void clickWhenVisible(By locator) {
		WebElement element = waitUntilVisible(locator);
		element.click();
	}
	
	public void enterTextWhenVisible(By locator, String text) {
		WebElement element = waitUntilVisible(locator);
		element.sendKeys(text);
	}
	
	public void selectByVisibleTextWhenVisible(By locator, String text) {
		WebElement element = waitUntilVisible(locator);
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public boolean checkElementIsDisplayed(By locator) {
		WebElement element = waitUntilVisible(locator);
		return element.isDisplayed();
	}
	
	public boolean checkboxIsSelected(By locator) {
		WebElement element = waitUntilVisible(locator);
		return element.isSelected();
	}
	
	public void tearDown() {
		driver.quit();
	}

}
