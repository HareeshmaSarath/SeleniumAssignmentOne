package testNGAssignment;

import org.testng.annotations.Test;

import utility.TakeScreenshot;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class GoogleSearchTest {
	
	WebDriver driver;
	TakeScreenshot screenshot;

	@Test(priority = 2)
	@Parameters({"fo"})
	public void parameterizartionGoogleSearchCheck(String searchWord) {
		WebElement search_box=driver.findElement(By.id("APjFqb"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(5));
		wait.until(ExpectedConditions.visibilityOf(search_box));
		search_box.sendKeys(searchWord,Keys.ENTER);
	}
	
	@Test(priority = 1)
	@Parameters({"ap"})
	public void javascriptExecuterGoogleSearchCheck(String searchWord) {
		WebElement search_box=driver.findElement(By.id("APjFqb"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(20));
		wait.until(ExpectedConditions.visibilityOf(search_box));
		search_box.sendKeys(searchWord);
		
		WebElement button=driver.findElement(By.className("gNO89b"));
		wait.until(ExpectedConditions.visibilityOf(search_box));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",button);
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			screenshot=new TakeScreenshot();
			screenshot.takeScreenshot(driver, result.getName());
		}
		driver.quit();
	}
}