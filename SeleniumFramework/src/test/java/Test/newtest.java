package Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Screens.DXHomeAct;

public class newtest {

	
	private static WebDriver driver =null;
	static Properties prop= new Properties();
	static String PrjPath=System.getProperty("user.dir");
	public static void main(String[] args) {
		getProperties();
		setProperties();
		getProperties();
		//flightSearchtest();
		// TODO Auto-generated method stub

	}
	
	
	
	public static void getProperties() {
		
		
		try {
			
			
			InputStream input=new FileInputStream(PrjPath+"\\src\\test\\java\\config\\config.properties");
			prop.load(input);
			String browser=prop.getProperty("browser");
			System.out.println(browser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
public static void setProperties() {
		
		
		try {
						String PrjPath=System.getProperty("user.dir");
			OutputStream output=new FileOutputStream(PrjPath+"\\src\\test\\java\\config\\config.properties");
			//prop.load(input);
			prop.setProperty("browser","firefox");
			prop.store(output,"test");
		//	System.out.println(browser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public static void flightSearchtest() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\SG0228076\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver =new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://dx.dx13.cert.aws.sabre.com/dx/VNDX/#/home");
		System.out.print(driver.getTitle());
		
		DXHomeAct homeOBJ=new DXHomeAct(driver);
		homeOBJ.joureny_Type();
		homeOBJ.From_City("Bangkok");
		homeOBJ.To_City("SGN");
		
	}
	
	

}
