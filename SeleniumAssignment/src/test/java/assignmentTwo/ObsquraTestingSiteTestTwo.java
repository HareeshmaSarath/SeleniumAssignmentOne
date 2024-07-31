package assignmentTwo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ObsquraTestingSiteTestTwo {

	WebDriver driver;

	@Test
	public void verifyTableHeadings() {
		List<WebElement> col = driver.findElements(By.xpath("//table[@class='dataTable']//thead//tr//th"));
		int colsize = col.size();
		System.out.println("Table Heading");
		System.out.println("----------------");
		for (int c = 1; c <= colsize; c++) {
			String text = driver.findElement(By.xpath("//table[@class='dataTable']//thead//tr//th[" + c + "]"))
					.getText();
			System.out.println(text);
		}
		System.out.println();
	}

	@Test
	public void printFirstRowValues() {
		List<WebElement> col = driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr[1]//td"));
		int colsize = col.size();
		System.out.println("First Row Values");
		System.out.println("-------------------");
		for (int c = 1; c <= colsize; c++) {
			String values = driver.findElement(By.xpath("//table[@class='dataTable']//tbody//tr[1]//td[" + c + "]"))
					.getText();
			System.out.println(values);
		}
		System.out.println();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
