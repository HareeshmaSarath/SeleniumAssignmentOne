package assignmentTwo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ObsquraTestingSiteTestOne {

	WebDriver driver;

	@Test
	public void verifyBasicSeleniumCommands() {
		driver.findElement(By.xpath("(//a[@href='simple-form-demo.php'])[1]")).click();
		driver.findElement(By.xpath("//a[text()='Form Submit']")).click();
		driver.findElement(By.id("validationCustom01")).sendKeys("Nimmi");
		driver.findElement(By.id("validationCustom02")).sendKeys("Nimz");
		driver.findElement(By.id("validationCustomUsername")).sendKeys("NimmiNimz");
		driver.findElement(By.id("validationCustom03")).sendKeys("Trivandrum");
		driver.findElement(By.id("validationCustom04")).sendKeys("Kerala");
		driver.findElement(By.id("validationCustom05")).sendKeys("123456");
		driver.findElement(By.id("invalidCheck")).click();
		driver.findElement(By.xpath("//button[text()='Submit form']")).click();
		String Message = driver.findElement(By.id("message-one")).getText();
		System.out.println("Message:" + Message);
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/simple-form-demo.php");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
