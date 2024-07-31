package assignmentOne;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentOrngSiteLogin {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement usernameTextFeild=driver.findElement(By.name("username"));
		usernameTextFeild.clear();
		usernameTextFeild.sendKeys("Admin");
		
		WebElement passwordTextFeild=driver.findElement(By.name("password"));
		passwordTextFeild.clear();
		passwordTextFeild.sendKeys("admin123");
		
		WebElement loginButton=driver.findElement(By.tagName("button"));
		loginButton.click();
	}

}