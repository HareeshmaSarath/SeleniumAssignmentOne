package assignmentOne;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowHandle {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		
		WebElement multipleWButtonClick=driver.findElement(By.id("newWindowsBtn"));
		String parentHandle=driver.getWindowHandle();
		JavascriptExecutor scroll=(JavascriptExecutor) driver;
		scroll.executeScript("arguments[0].scrollIntoView();", multipleWButtonClick);
		multipleWButtonClick.click();
		
		Set<String> multipleHandles=driver.getWindowHandles();
		for (String handle : multipleHandles) 
		{
			if(!handle.equalsIgnoreCase(parentHandle))
			{
				driver.switchTo().window(handle);
				String title=driver.getTitle();
				//System.out.println(title);
				if(title.equals("XPath Practice - H Y R Tutorials"))
				{
					driver.manage().window().maximize();
					WebElement firstName=driver.findElement(By.xpath("(//input[@type='text'])[1]"));
					firstName.sendKeys("Nimmi");
					WebElement lastName=driver.findElement(By.xpath("(//input[@type='text'])[2]"));
					lastName.sendKeys("John");
					WebElement email=driver.findElement(By.xpath("(//input[@type='text'])[3]"));
					email.sendKeys("nimmi@gmail.com");
					WebElement password=driver.findElement(By.xpath("(//input[@type='password'])[1]"));
					password.sendKeys("12345");
					WebElement rPassword=driver.findElement(By.xpath("(//input[@type='password'])[2]"));
					rPassword.sendKeys("12345");
					WebElement registerButton=driver.findElement(By.xpath("//button[text()='Register']"));
					JavascriptExecutor scrl=(JavascriptExecutor) driver;
					scrl.executeScript("arguments[0].scrollIntoView();", registerButton);
					registerButton.click();
					driver.close();
				}
				else if(title.equals("Basic Controls - H Y R Tutorials"))
				{
					driver.manage().window().maximize();
					//driver.switchTo().alert().dismiss();
					/*
					 * WebElement
					 * addBlock=driver.findElement(By.xpath("(//*[@fill='#5F6368'])[1]"));
					 * addBlock.click();
					 */
					WebElement firstN=driver.findElement(By.name("fName"));
					firstN.sendKeys("Jiji");
					WebElement lastN=driver.findElement(By.name("lName"));
					lastN.sendKeys("J");
					
					WebElement femaleRadio=driver.findElement(By.id("femalerb"));
					JavascriptExecutor scrl=(JavascriptExecutor) driver;
					scrl.executeScript("arguments[0].scrollIntoView();", femaleRadio);
					//scrl.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
					femaleRadio.click();
					
					WebElement checkEnglish=driver.findElement(By.id("englishchbx"));
					checkEnglish.click();
					WebElement checkHindi=driver.findElement(By.id("hindichbx"));
					checkHindi.click();
					WebElement emailid=driver.findElement(By.id("email"));
					emailid.sendKeys("jiji@gmail.com");
					WebElement password=driver.findElement(By.id("password"));
					password.sendKeys("12345");
					WebElement regButton=driver.findElement(By.id("registerbtn"));
					regButton.click();
					driver.close();
				}
			}
		}
		
		driver.switchTo().window(parentHandle);
		WebElement headingW=driver.findElement(By.xpath("//h1[@itemprop='name']"));
		System.out.println(headingW.isDisplayed());
		System.out.println(headingW.getText());

	}

}