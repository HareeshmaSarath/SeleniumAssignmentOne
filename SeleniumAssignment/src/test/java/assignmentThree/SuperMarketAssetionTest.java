package assignmentThree;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class SuperMarketAssetionTest {
	WebDriver driver;

	@Test
	public void verifyRememberMeCheckBoxIsSelectedOrNot() {
		WebElement checkbox_rememberme = driver.findElement(By.id("remember"));
		boolean select = checkbox_rememberme.isSelected();

		// Assert.assertEquals(select, false);

		if (select == true) {
			System.out.println("Its checked By Default");
		} else {
			System.out.println("Its Unchecked By Default");
		}

	}

	@Test
	public void verifySuccessfullLogin() {
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement loginbutton = driver.findElement(By.xpath("//button[@type='submit']"));
		username.sendKeys("admin");
		password.sendKeys("admin");
		loginbutton.click();
		WebElement nameofuser = driver.findElement(By.linkText("Admin"));
		String actual_result = nameofuser.getText();
		String expect_result = "Admin";
		Assert.assertEquals(actual_result, expect_result);
	}

	@Test
	public void verifyUnsuccessfullLoginUsingErrorMessage() {
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement loginbutton = driver.findElement(By.xpath("//button[@type='submit']"));
		username.sendKeys("admin175");
		password.sendKeys("admin");
		loginbutton.click();
		WebElement alert = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		String alert_msg = alert.getText();
		if (alert_msg.contains("Alert!\n" + "Invalid Username/Password")) {
			System.out.println("Invalid Login alert shows..!!");
		} else {
			System.out.println("Not showing error alert..!!");
		}
	}

	@Test
	public void verifyUnsuccessfullLoginByURL() {
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement loginbutton = driver.findElement(By.xpath("//button[@type='submit']"));
		username.sendKeys("admin");
		password.sendKeys("159753");
		loginbutton.click();
		String expected_url = "https://groceryapp.uniqassosiates.com/admin";
		String actual_url = driver.getCurrentUrl();
		Assert.assertNotEquals(actual_url, expected_url);
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		// driver.quit();
	}

}
