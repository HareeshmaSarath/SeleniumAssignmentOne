package assignmentTwo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class FileUploadTest {
	WebDriver driver;

	@Test
	public void loginWithCredentials() throws InterruptedException, AWTException {
		driver.findElement(By.id("login_field")).sendKeys("himah1010@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Himah@1010");
		driver.findElement(By.xpath("//input[@name='commit']")).click();

		driver.findElement(By.xpath("//summary[@role='button']")).click();
		
		Actions actions = new Actions(driver);
		WebElement upload = driver.findElement(By.xpath("//label[@role='menuitem']"));
		actions.moveToElement(upload).click().perform();
		Thread.sleep(1000);
		
		Robot rb = new Robot();
		StringSelection file = new StringSelection("D:\\Images\\Rose.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.delay(12);
		rb.keyPress(KeyEvent.VK_V);
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.delay(12);
		rb.keyRelease(KeyEvent.VK_V);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.delay(12);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//details-dialog")));
		driver.findElement(By.xpath("//*[text()='Set new profile picture']")).click();
		
		//driver.findElement(By.id("Update profile")).click();
	}
	
	@Test
	public void sendKeysMethod() throws InterruptedException {
		driver.findElement(By.id("login_field")).sendKeys("himah1010@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Himah@1010");
		driver.findElement(By.xpath("//input[@name='commit']")).click();

		driver.findElement(By.xpath("//summary[@role='button']")).click();
		WebElement file=driver.findElement(By.id("avatar_upload"));
		file.sendKeys("D:\\Images\\Rose.jpg");
		
		//Thread.sleep(2000);3
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//details-dialog")));
		driver.findElement(By.xpath("//span[text()='Set new profile picture']")).click();
		Thread.sleep(2000);
		
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.get("https://github.com/settings/profile");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}