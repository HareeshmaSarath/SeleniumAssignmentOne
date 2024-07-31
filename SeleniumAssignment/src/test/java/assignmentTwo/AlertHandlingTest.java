package assignmentTwo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class AlertHandlingTest {
	WebDriver driver;

	@Test
	public void verifyAlertHandlingButtonClicks() throws InterruptedException {
		driver.findElement(By.id("alertBox")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		WebElement confirm = driver.findElement(By.id("confirmBox"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", confirm);
		confirm.click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);

		driver.findElement(By.id("promptBox")).click();
		driver.switchTo().alert().sendKeys("nimmi");
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.id("output")).getText());
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html?m=1");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
