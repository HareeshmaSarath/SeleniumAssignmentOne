package assignmentOne;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ObsquraSeleniumSite {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://selenium.qabible.in/");
		driver.manage().window().maximize();
		
		WebElement logoImage=driver.findElement(By.xpath("(//img[@alt='logo'])[1]"));
		Point location= logoImage.getLocation();
		System.out.println(location);
		Dimension size= logoImage.getSize();
		System.out.println(size);
		
		WebElement inputFormMenu=driver.findElement(By.xpath("//a[contains(@href,'simple-form-demo')]"));
		inputFormMenu.click();
		
		WebElement radioButtonDemoLeftMenu=driver.findElement(By.xpath("//a[text()='Radio Buttons Demo']"));
		radioButtonDemoLeftMenu.click();
		
		WebElement femaleRadio=driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
		femaleRadio.click();
		/*
		 * boolean femaleSelect=femaleRadio.isSelected();
		 * System.out.println(femaleSelect);
		 */
		WebElement selectButton=driver.findElement(By.xpath("//button[text()='Show Selected Value']"));
		selectButton.click();
		
		WebElement hideTextMessage=driver.findElement(By.xpath("//div[@id='message-one']"));
		String text=hideTextMessage.getText();
		System.out.println(text);
		
		WebElement femaleRadioGroup=driver.findElement(By.id("inlineRadio21"));
		femaleRadioGroup.click();
		
		WebElement ageRadioButton=driver.findElement(By.id("inlineRadio24"));
		ageRadioButton.click();
		
		WebElement getResult=driver.findElement(By.id("button-two"));
		getResult.click();
		
		WebElement hiddenMessage=driver.findElement(By.id("message-two"));
		String message=hiddenMessage.getText();
		System.out.println(message);
		
		driver.navigate().refresh();
		
		/*
		 * WebElement maleButtonOne=driver.findElement(By.id("inlineRadio1"));
		 * System.out.println(maleButtonOne.isSelected()); WebElement
		 * maleButtonTwo=driver.findElement(By.id("inlineRadio11"));
		 * System.out.println(maleButtonOne.isSelected());
		 */
		List<WebElement>  maleButtons=driver.findElements(By.xpath("//input[@value='Male']"));
		for (WebElement webElement : maleButtons) 
		{
			boolean element=webElement.isSelected();
			System.out.println(element);
		}
		
		List<WebElement> allRadioButtons=driver.findElements(By.xpath("//input[@type='radio']"));
		for (WebElement webElement : allRadioButtons) 
		{
			webElement.click();
		}
		
		System.out.println();
		
		List<WebElement> allRadioButtonsOne=driver.findElements(By.xpath("//input[@type='radio']"));
		for (WebElement element : allRadioButtonsOne) 
		{
			boolean select=element.isSelected();
			System.out.println(select);
		}
		
	}
}