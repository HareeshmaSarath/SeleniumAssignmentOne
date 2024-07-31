package assignmentOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FramesAssignment {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("frm1");
		
		WebElement select=driver.findElement(By.id("course"));
		Select course=new Select(select);
		course.selectByValue("java");
		
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame("frm2");
		
		String firstName=driver.findElement(By.id("firstName")).getAttribute("placeholder");
		System.out.println(firstName);
		
		driver.switchTo().defaultContent();
		driver.close();

	}
}