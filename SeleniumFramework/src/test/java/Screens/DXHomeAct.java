package Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DXHomeAct {
	
WebDriver driver;		
		
		By joureytype=By.id("tab-one-way");
		By From =By.id("airport-selection-origin");
		By To=By.id("airport-selection-destination");
		
		public  void joureny_Type() {
		
			WebElement journeyType=driver.findElement(joureytype);
			//return journeyType;
			journeyType.click();
		
		}
		
		public void From_City(String Fcity) {
			
			WebElement origin = driver.findElement(From);
			origin.sendKeys(Fcity);
			origin.sendKeys(Keys.ENTER);
			
		
			}

		public void To_City(String Tcity) {
			
			WebElement origin = driver.findElement(To);
			origin.sendKeys(Tcity);
			origin.sendKeys(Keys.ENTER);
					
			}

		public DXHomeAct(WebDriver driver)
			{
			this.driver=driver;
			}

}
