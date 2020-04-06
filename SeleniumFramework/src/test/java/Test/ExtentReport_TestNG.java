package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Screens.DXHomeAct;

public class ExtentReport_TestNG {
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;;
	ExtentTest test;

	@BeforeSuite
	public void setup() {
		htmlReporter = new ExtentHtmlReporter("extentTestNG.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test = extent.createTest("DXFlight Search", "Test Search");
		
		// creates a toggle for the given test, adds all log events under it    


	}
	
	
	@BeforeTest
	public void openBrowser() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\SG0228076\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://dx.dx13.cert.aws.sabre.com/dx/VNDX/#/home");
	//	System.out.print(driver.getTitle());

		test.log(Status.INFO, "Launch DX)");


		// log with snapshot
		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot1.png").build());

		// test with snapshot
		test.addScreenCaptureFromPath("Test1.png");
		Thread.sleep(5000);
	}
	
	
	@Test
	public void flightSearchtest() throws Exception {

		DXHomeAct homeOBJ=new DXHomeAct(driver);
		homeOBJ.joureny_Type();
		homeOBJ.From_City("Bangkok");
		homeOBJ.To_City("SGN");

		test.log(Status.INFO, "Input Details)");
		// log with snapshot
		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot2.png").build());
		// test with snapshot
		test.addScreenCaptureFromPath("Test2.png");


	}

	@AfterTest
	public void closeBrowser() throws Exception {

		driver.close();
		driver.quit();
		//System.out.println("Test Completed");
		test.log(Status.INFO, "closebrowser");
		// log with snapshot
		test.pass("Browser Closed");
		// test with snapshot
		//test.addScreenCaptureFromPath("Test3.png");

	}


	@AfterSuite	
	public void tearDown() {

		extent.flush();

	}

}
