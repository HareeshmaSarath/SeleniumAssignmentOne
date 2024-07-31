package assignmentFour;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.beans.Visibility;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class WaitsTest {
	WebDriver driver;

	@Test
	public void verifyTheCurrectPageIsOpened() {
		WebElement heading = driver.findElement(By.xpath("//h5[text()='Login']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.visibilityOf(heading));
		boolean visibility=heading.isDisplayed();
		Assert.assertTrue(visibility);
	}

	@Test
	public void verifyTheLogoIsPresentInLoginPage() {
		WebElement logo = driver.findElement(By.xpath("//img[@alt='company-branding']"));
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		 * wait.until(ExpectedConditions.visibilityOf(logo));
		 */
		Wait<WebDriver> fluent = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(3))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
		fluent.until(ExpectedConditions.visibilityOf(logo));
		Assert.assertTrue(logo.isDisplayed());
	}
	
	@Test
	public void verifyTheComapnyHipherLinkInBottomOfLoginPage() {
		WebElement company_name=driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='OrangeHRM, Inc']")));
		boolean vivibility=company_name.isDisplayed();
		Assert.assertTrue(vivibility, "Not Found");
	}
	
	@Test
	public void verifySuccessfullLogin() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actual_result=driver.findElement(By.className("oxd-userdropdown-name")).getText();
		String Expected_result="manda user";
		Assert.assertEquals(actual_result, Expected_result);
	}
	
	@Test
	public void verifySuccessfullLoginConatins() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("oxd-userdropdown-name")));
		
		WebElement actual_result=driver.findElement(By.className("oxd-userdropdown-name"));
		String a_text=actual_result.getText();
		String Expected_result="Pruthviraj Gharge";
		Assert.assertTrue(a_text.contains(Expected_result));
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
