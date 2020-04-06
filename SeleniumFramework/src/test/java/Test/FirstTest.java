package Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Screens.DXHome;



public class FirstTest {

	WebDriver driver;


	public void launchBrowser(String URL) {
		// TODO Auto-generated method stub
		try {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\SG0228076\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			driver =new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://dx.dx13.cert.aws.sabre.com/dx/VNDX/#/home");
			System.out.print(driver.getTitle());
		
			//journey type
			//WebElement journeyType=driver.findElement(By.id("tab-one-way"));
			//journeyType.click();
		
			DXHome.joureny_Type(driver, "Oneway");
			DXHome.To_City(driver, "Bangkok");
					     
			//origin
		/*	WebElement origin = driver.findElement(By.id("airport-selection-origin"));
			origin.sendKeys("Bangkok");
			origin.sendKeys(Keys.ENTER);*/
			
			//To
			
			WebElement departure = driver.findElement(By.id("airport-selection-destination"));
			departure.sendKeys("SGN");
			departure.sendKeys(Keys.ENTER);
		
			//Adult count
			
			driver.findElement(By.className("passenger-selection-button")).click();
			Thread.sleep(1000);
			List<WebElement> paxCount=driver.findElements(By.className("btn-increment"));
			System.out.print(paxCount.size());
			paxCount.get(0).click();
			driver.findElement(By.className("passenger-selection-button")).click();
			Thread.sleep(1000);
			
			
			
			
			//driver.findElement(By.xpath("//*[@id=\"FieldDate-departureDate--input\"]")).sendKeys("24/03/2020");
			//Thread.sleep(3000);
			//driver.findElement(By.xpath("//input[@id='FieldDate-departureDate--input']")).clear();
			//Thread.sleep(5000);
			
			//departure date
			driver.findElement(By.xpath("//*[@id=\"FieldDate-departureDate--input\"]")).click();
			
			//input[@id='FieldDate-departureDate--input']
		    WebElement month= driver.findElement(By.xpath("//button[@class='dp-nav-view dp-cell']//span[2]"));
		//System.out.println("\n month="+ month.getText());
		//driver.findElement(By.xpath("//button[@class='dp-next-nav dp-nav-cell dp-cell']")).click();
		//System.out.println("\n month="+ month.getText());
		
		
			//List<WebElement> dateFLT=driver.findElements(By.className("dxp-field-date-value"));
			//System.out.print(dateFLT.size());
			//dateFLT.get(0).clear();
		while (!month.getText().contains("April"))
		{
			driver.findElement(By.xpath("//button[@class='dp-next-nav dp-nav-cell dp-cell']")).click();	
		
		}
		
		WebElement dateWidgetFrom = driver.findElement(By.className("dp-table-body"));
		List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));	
		System.out.print(columns.size());	
		Thread.sleep(2000);
		
		for (WebElement cell: columns) {
            /*
            //If you want to click 18th Date
            if (cell.getText().equals("18")) {
            */
            //Select Today's Date
			System.out.print("\n");
			System.out.print(cell.getText());
			
					
            if (cell.getText().equals("31") && cell.isEnabled()) {
                cell.click();
                //cell.
                break;
            }
          }	
		
		//WebElement date= driver.findElement(By.xpath("//*[@id=\"FieldDate-departureDate--input\"]"));
		//date.sendKeys(Keys.BACK_SPACE);
		
		
		//submit
		WebElement buttonSubmit=driver.findElement(By.id("searchSubmit"));
		buttonSubmit.click();
		

	//load more flights
		
		boolean b= driver.findElement(By.xpath("//button[contains(text(),'more results')]")).isDisplayed();
		if (b) 
		{
			
			driver.findElement(By.xpath("//button[contains(text(),'more results')]")).click();
			//driver.findElement(By.xpath("//*[@id=\"dxp-flight-table-section\"]/div[12]/button")).click();
		}
		
	//flight selection
		List<WebElement> flightrow = driver.findElements(By.className("itinerary-part-offer-header"));
		System.out.print("\n Flight Rows");
		List<WebElement> fltbutton = flightrow.get(0).findElements(By.xpath("//div[@class='itinerary-part-offer-prices']/div/div/button"));
				
		System.out.print("\n");
		
		System.out.print(flightrow.size() + "\n" + "\n buttoncount" + fltbutton.size() + "\n" + fltbutton.get(0).getText());
		
		
		//div[3]//div[1]//div[1]//div[2]//div[1]//div[1]//button[1]
		//flightrow.get(0).getText();
		
		List<WebElement> fltnum = driver.findElements(By.className("flight-number"));	
		System.out.print("\n");
		System.out.print(fltnum.size());
		
	//WebElement fltClass = driver.findElement(By.className("offer-labels"));	
		List<WebElement> rbd = driver.findElements(By.xpath("//div[@class='offer-label flex-1']"));
		System.out.print("\n");
		System.out.print("cabin count is: "+rbd.size());
		
		
		List<WebElement> fltSelect = driver.findElements(By.xpath("//div[@class='itinerary-part-offer-price']"));
		System.out.print("\n");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(250, 0)");
		
		Thread.sleep(10000);
		 //fltSelect.get(1).click();
		//int x=fltSelect.get(0).getLocation().x;
		//int y=fltSelect.get(0).getLocation().y;
		//System.out.println("loc="+x+"\n"+y);
		//JavascriptExecutor js =(JavascriptExecutor)driver;
        //js.executeScript("window.scrollTo(0,"+x+")"); 
        	//fltSelect.get(0).click();
		
		
		 
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", fltSelect.get(10));
		//   Thread.sleep(10000);
		
		

		Actions actions = new Actions(driver);
		actions.moveToElement(fltSelect.get(4)).perform();
		Thread.sleep(5000);
		//actions.sendKeys(Keys.PAGE_DOWN).build().perform();
	//	Thread.sleep(5000);
		System.out.print("flight select button count is: "+ fltSelect.size() +"\n" + fltSelect.get(3).getText());
		//driver.close();
		//fltSelect.get(3).sendKeys("");
		fltSelect.get(2).click();
		 
		 List<WebElement> priceButton = driver.findElements(By.xpath("//button[@class='ducp-component-button brand-select-button spark-btn--primary spark-btn--md']//div[@class='brand-offer-price']"));
			System.out.print("\n");
			System.out.print("price button count is: "+ priceButton.size());
		    priceButton.get(0).click();
		
		
		   driver.findElement(By.xpath("//span[contains(text(),'Continue')]"));
		   /*Actions actions = new Actions(driver);
		actions.moveToElement(fltSelect.get(1));
		actions.perform();
	*/
		//JavascriptExecutor jse = (JavascriptExecutor)driver;

		//jse.executeScript("window.scrollBy(0,0)", "");
		  Thread.sleep(5000);
		//((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		 // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fltSelect.get(1));
		   Thread.sleep(5000);
			// fltSelect.get(1).click();
			 
			 
	/*	
		
	//	brand-selection-button-container
		//for (WebElement flt: fltnum) {
            /*
            //If you want to click 18th Date
            if (cell.getText().equals("18")) {
            */
            //Select Today's Date
		
		//	if(flt.getText().equals("VN 604")) {
				
				
			//}
          // }	

		
		//driver.findElement(By.id("departureDate")).sendKeys("24/03/2020");
		
		
			
			
			//driver.findElement(By.id("airport-selection-origin")).sendKeys;
			//driver.findElement(By.cssSelector(".Select-input__control--is-focused > .Select-input__value-container")).click();
			
			//driver.wait(30);
			///driver.findElement(By.id(id))
			//driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//public void firstfuncation()
//	{
		
		
	//}
	
public static void main(String[] args) {
	FirstTest obj=new FirstTest();
	obj.launchBrowser("https://dx.dx13.cert.aws.sabre.com/dx/VNDX/#/home");
	

	}	
	
}
