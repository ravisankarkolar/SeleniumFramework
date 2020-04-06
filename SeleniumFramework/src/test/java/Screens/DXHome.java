package Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DXHome {

	public static void joureny_Type(WebDriver driver, String jtype) {
	
	WebElement journeyType=driver.findElement(By.id("tab-one-way"));
	//return journeyType;
	journeyType.click();
	
	}
	
	public static void From_City(WebDriver driver, String From) {
		
		WebElement origin = driver.findElement(By.id("airport-selection-origin"));
		origin.sendKeys("Bangkok");
		origin.sendKeys(Keys.ENTER);
		
	
		}

	public static void To_City(WebDriver driver,String To) {
		
		WebElement origin = driver.findElement(By.id("airport-selection-origin"));
		origin.sendKeys("Bangkok");
		origin.sendKeys(Keys.ENTER);
		
	
		}


}
