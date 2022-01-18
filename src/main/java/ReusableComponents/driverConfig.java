package ReusableComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utilities.dateTimeHelper;

public class driverConfig {
	public static WebDriver driver=null;
	public static FileInputStream file=null;
	public static Properties prop=null;
	public static WebDriver driverConfiguration() throws IOException{
		//Data Driving using properties
		prop=new Properties();
		file = new FileInputStream(".//src//main//java//Utilities//Properties//dataDriven.properties");
		prop.load(file);
		if(prop.getProperty("browser").contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		} else if(prop.getProperty("browser").contains("firefox")) {
			driver=new FirefoxDriver();
		} else if(prop.getProperty("browser").contains("Edge")) {
			driver=new EdgeDriver();
		} else {
			System.out.println("Invalid Browser");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	public static String getscreenshotpath(String TestCaseName) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String target = (System.getProperty("user.dir")+"/Screenshots/Screenshot_"+TestCaseName+"_"+dateTimeHelper.getCurrentDateTime()+".png");
		File file=new File(target);
		FileUtils.copyFile(source, file);
		return target;
	}
}
