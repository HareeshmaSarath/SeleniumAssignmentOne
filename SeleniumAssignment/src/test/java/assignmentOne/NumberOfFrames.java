package assignmentOne;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NumberOfFrames {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/frames");
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		
		List<WebElement> frameLi=driver.findElements(By.tagName("iframe"));
		System.out.println("Number of Iframes:"+frameLi.size());
		driver.close();
	}
}