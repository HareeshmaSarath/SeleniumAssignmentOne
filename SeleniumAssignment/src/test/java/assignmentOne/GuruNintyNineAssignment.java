package assignmentOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GuruNintyNineAssignment {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/ajax.html");
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		WebElement yesRadio=driver.findElement(By.id("yes"));
		boolean selectY=yesRadio.isSelected();
		System.out.println(selectY);
		
		WebElement noRadio=driver.findElement(By.id("no"));
		noRadio.click();
		boolean selectN=noRadio.isSelected();
		System.out.println(selectN);
		
		driver.close();

	}
}