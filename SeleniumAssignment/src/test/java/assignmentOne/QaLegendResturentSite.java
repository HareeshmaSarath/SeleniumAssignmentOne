package assignmentOne;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class QaLegendResturentSite {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://qalegend.com/restaurant/login");
		driver.manage().window().maximize();
		driver.navigate().refresh();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement usernameElmt=driver.findElement(By.xpath("//input[@name='username']"));
		usernameElmt.clear();
		usernameElmt.sendKeys("lulla");
		WebElement passwordElmt=driver.findElement(By.xpath("//input[@name='password']"));
		passwordElmt.clear();
		passwordElmt.sendKeys("123456");
		WebElement loginButton=driver.findElement(By.xpath("//input[@name='submit']"));
		loginButton.click();
		
		WebElement profileName=driver.findElement(By.xpath("//*[@class='hidden-xs']")); // 
		String pName=profileName.getText();
		System.out.println(pName);
		
		WebElement menuItemProduct=driver.findElement(By.xpath("(//span[@class='menu-text'])[2]"));
		menuItemProduct.click();
		
		WebElement productAddButton=driver.findElement(By.xpath("//button[@data-target='#Addproduct']"));
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView", productAddButton);
		//jse.executeScript("arguments[0].click();", productAddButton);
		productAddButton.click();
		
		/*
		 * Add Product From modal
		 */
		WebElement code=driver.findElement(By.id("ProductCode"));
		code.sendKeys("C1234");
		WebElement name=driver.findElement(By.id("ProductName"));
		name.sendKeys("Mobile");
		WebElement purchasePrice=driver.findElement(By.id("PurchasePrice"));
		purchasePrice.sendKeys("1500"); //Result shows 500 in form
		WebElement price=driver.findElement(By.id("Price"));
		price.sendKeys("16000");
		
		WebElement SubmitButton=driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		SubmitButton.click();
		
		WebElement nextButton=driver.findElement(By.xpath("//button[@onclick='updatestock()']"));
		nextButton.click();
		
		
	}
}