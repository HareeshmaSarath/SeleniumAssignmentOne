package assignmentTwo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class DropDownHandlingTest {

	WebDriver driver;

	@Test
	public void valuesOfCourseNameDropBox() {
		Select select = new Select(driver.findElement(By.id("course")));
		List<WebElement> drop = select.getOptions();
		for (WebElement element : drop) {
			System.out.println(element.getText());
		}
	}

	@Test
	public void findNumberOfDropDowns() {
		List<WebElement> no_Dorp = driver.findElements(By.xpath("//select"));
		System.out.println("Number Of DropDown In Page:" + no_Dorp.size());
	}

	@Test
	public void selectCourseAndPrintValue() {
		Select drop = new Select(driver.findElement(By.id("course")));
		drop.selectByVisibleText("Python");
		WebElement selectOpt = drop.getFirstSelectedOption();
		System.out.println(selectOpt.getText());
	}

	@Test
	public void findIDEDropDownIsMulti() {
		Select drop = new Select(driver.findElement(By.id("ide")));
		boolean multi = drop.isMultiple();
		if (multi == true) {
			System.out.println("Multi");
		} else {
			System.out.println("Not Multi");
		}
	}

	@Test
	public void valueSelectInIDEAndPrint() {
		Select mdrop = new Select(driver.findElement(By.id("ide")));
		mdrop.selectByValue("ec");
		mdrop.selectByValue("ij");
		mdrop.selectByValue("vs");
		System.out.println("All selected Values");
		List<WebElement> values = mdrop.getAllSelectedOptions();
		for (WebElement ele : values) {
			System.out.println(ele.getText());
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html?m=1");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
