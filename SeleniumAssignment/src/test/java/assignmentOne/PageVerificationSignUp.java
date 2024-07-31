package assignmentOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageVerificationSignUp {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/sign-up");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("fname")).sendKeys("Nimmi");
		driver.findElement(By.name("lname")).sendKeys("Nikil");
		driver.findElement(By.name("email")).sendKeys("Nimmi@gmail.com");
		driver.findElement(By.name("phone")).sendKeys("7867564321");
		driver.findElement(By.name("password1")).sendKeys("nimmi123");
		driver.findElement(By.name("password2")).sendKeys("nimmi123");
		driver.findElement(By.className("next_ch02")).click();
		
		String expectedUrl="https://groceryapp.uniqassosiates.com/otp?s=signup";
		String expectedtTitle="OTP | 7rmart supermarket";
		
		if(driver.getTitle()!=null&&driver.getTitle().equals(expectedtTitle)&&driver.getCurrentUrl().equals(expectedUrl))
		{
			System.out.println("Navigated to correct OTP webpage");
		}
		else
		{
			System.out.println("Didn't navigate to correct webpage");
		}
		driver.close();
	}
}