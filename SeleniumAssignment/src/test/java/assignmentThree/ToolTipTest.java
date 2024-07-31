package assignmentThree;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ToolTipTest {
	WebDriver driver;
	Actions act;

	@Test
	public void verifyToolTipInElementLiveUsingGetAttribute() {
		String expected_toolTip = "Live";
		WebElement label_Live = driver.findElement(By.xpath("(//a[@aria-label='Live'])[3]"));
		String actual_tooltip = label_Live.getAttribute("title");
		if (actual_tooltip.equals(expected_toolTip)) {
			System.out.println("The tool tip is showing");
		} else {
			System.out.println("Not showing");
		}
	}

	@Test
	public void verifyToolTipIsShowingOrNotUsingActionClass() throws InterruptedException {
		act = new Actions(driver);
		WebElement label_Live = driver.findElement(By.xpath("(//a[@aria-label='Live'])[3]"));
		act.moveToElement(label_Live).build().perform();
		Thread.sleep(2000);
		String actual_tooltip = label_Live.getAttribute("title");
		Assert.assertEquals(actual_tooltip, "Live");

	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.get("https://www.browserstack.com/");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		// driver.quit();
	}

}
