package assignmentOne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAssignment {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		
		driver.get("https://groceryapp.uniqassosiates.com/home");
		driver.navigate().refresh();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().to("https://groceryapp.uniqassosiates.com/sign-up");
		driver.navigate().refresh();
		driver.navigate().back();
		driver.close();
	}
}