package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Screens.DXHomeAct;

public class ExtentReportBasic {
private static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   // start reporters
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
    
        // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // creates a toggle for the given test, adds all log events under it    
        ExtentTest test = extent.createTest("DXFlight Search", "Test Search");

        
		System.setProperty("webdriver.chrome.driver","C:\\Users\\SG0228076\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver =new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://dx.dx13.cert.aws.sabre.com/dx/VNDX/#/home");
		//System.out.print(driver.getTitle());
		
		 test.log(Status.INFO, "Launching Browser)");
		
		DXHomeAct homeOBJ=new DXHomeAct(driver);
		homeOBJ.joureny_Type();
		test.pass("Journey type selected");
		
		homeOBJ.From_City("Bangkok");
		test.pass("Origin Selected");
		homeOBJ.To_City("SGN");
		test.pass("destination Selected");
		//test.addScreenCaptureFromPath(imagePath);		
		extent.flush();
		
        
        // log with snapshot
      //  test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
        // test with snapshot
       
        
        // calling flush writes everything to the log file
        extent.flush();
	}

}
