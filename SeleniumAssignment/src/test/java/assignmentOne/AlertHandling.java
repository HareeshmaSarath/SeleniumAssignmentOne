package assignmentOne;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		
		WebElement newTab=driver.findElement(By.id("newTabBtn"));
		String parentHandle=driver.getWindowHandle();
		JavascriptExecutor scroll=(JavascriptExecutor) driver;
		scroll.executeScript("arguments[0].scrollIntoView();", newTab);
		newTab.click();
		
		//System.out.println(driver.getTitle());
		
		Set<String> allOpenedWindw=driver.getWindowHandles();
		for (String handle : allOpenedWindw) 
		{
			if(!handle.equalsIgnoreCase(parentHandle))
			{
				driver.switchTo().window(handle);
				
				//System.out.println(driver.getTitle());
				
				WebElement firstClickMe=driver.findElement(By.id("alertBox"));
				firstClickMe.click();
				System.out.println("First Alert Text:"+driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();
				Thread.sleep(2000);
				
				WebElement promptBox=driver.findElement(By.id("promptBox"));
				JavascriptExecutor scrollWi=(JavascriptExecutor) driver;
				scrollWi.executeScript("arguments[0].scrollIntoView();", promptBox);
				promptBox.click();
				driver.switchTo().alert().sendKeys("Nimmi");
				driver.switchTo().alert().accept();
				Thread.sleep(2000);
				
				WebElement output=driver.findElement(By.xpath("//div[@id='output']"));
				System.out.println("OutPut from Alert:"+output.getText());
				
				//driver.close();
				driver.quit();
			}
		}
		
		//driver.switchTo().window(parentHandle);
		//driver.close();
	}
}
