package uiRepositories;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import PageObjects.footerPageObjects;
import PageObjects.navigateClass;
import ReusableComponents.driverConfig;

public class footerPageUI extends driverConfig{
	public ExtentReports reporte;
	public ExtentTest logger;
	
	public WebDriver driver;
	
	private static Logger log = Logger.getLogger(footerPageUI.class);
	
	public void siteNavigation(ExtentReports rep) throws IOException, InterruptedException {
		this.reporte=rep;
		PropertyConfigurator.configure(".//src//main//java//Utilities//Properties//log4j.properties");
		logger=reporte.createTest("Navigation to site");
		driver=driverConfiguration();
		//Navigation to site
		navigateClass nc=new navigateClass(driver);
		nc.navigate().to(prop.getProperty("URL"));
		//Extentreports method
		logger.pass("Navigated to site");
		//Log4jMethod
		log.info("Navigated to site");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element=nc.jsClick();
		js.executeScript("arguments[0].click();", element);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(5000);
	}
	
	public footerPageObjects fpo=null; 
	
	public void contactUs() {
		logger=reporte.createTest("Verifying the contact email element");
		fpo=new footerPageObjects(driver);
		WebElement contactLink=fpo.contactUsLink();
		String parent=driver.getWindowHandle();
		contactLink.click();
		Set<String>s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
		String child_window=I1.next();
		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		String contactEmail=fpo.contactUsemail().getText();
		if(contactEmail != null)
		{
			//Extentreports method
			logger.pass("The contact email of the site exists");
			//Log4jMethod
			log.info("The contact email of the site exists");
			Assert.assertTrue(true);
		}else {
			//Extentreports method
			logger.fail("The contact email of the site does not exists");
			//Log4jMethod
			log.error("The contact email of the site does not exists");
			Assert.assertTrue(false);
		}
		}
		}	
	}
	
	public void aboutUs() {
		logger=reporte.createTest("Verifying and matching the CEO Name");
		fpo=new footerPageObjects(driver);
		WebElement aboutLink=fpo.aboutUsLink();
		String parent=driver.getWindowHandle();
		aboutLink.click();
		Set<String>s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
		String child_window=I1.next();
		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		String ceoName=fpo.ceoname().getText();
		String expectedCeoName=prop.getProperty("ceo_name");
		if(ceoName.equalsIgnoreCase(expectedCeoName))
		{
			//Extentreports method
			logger.pass("CEO name matches as expected");
			//Log4jMethod
			log.info("CEO name matches as expected");
			Assert.assertTrue(true);
		}else {
			//Extentreports method
			logger.fail("CEO name does not match as expected");
			//Log4jMethod
			log.error("CEO name does not match as expected");
			Assert.assertTrue(false);
		}
		
		}
		}
	}
	
	public void siteMapCabType() {
		logger=reporte.createTest("Verifying the expected car if exists");
		fpo=new footerPageObjects(driver);
		fpo.sitemapLink().click();
		ArrayList<String> s=new ArrayList<String>(driver.getWindowHandles());
		String child_window=s.get(1);
		driver.switchTo().window(child_window);
		fpo.cabTypeLink().click();
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
			System.out.println(driver.getCurrentUrl());
			String cabName=fpo.cabName().getText();
			System.out.println(cabName);
			String expectedCabName=prop.getProperty("cabName");
			System.out.println(expectedCabName);
			if(cabName.equalsIgnoreCase(expectedCabName))
			{
				//Extentreports method
				logger.pass("Cab name matches as expected");
				//Log4jMethod
				log.info("Cab name matches as expected");
				Assert.assertTrue(true);
			}else {
				//Extentreports method
				logger.fail("Cab name does not match as expected");
				//Log4jMethod
				log.error("Cab name does not match as expected");
				Assert.assertTrue(false);
			}
	}
	
	public void carRentalCitiies() {
		logger=reporte.createTest("Verifying the expected number of passengers");
		fpo=new footerPageObjects(driver);
		String parent=driver.getWindowHandle();
		fpo.cityLink().click();
		Set<String>s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
		String child_window=I1.next();
		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String noOfPassengers=fpo.numberOfpassenger().getText();
		String expectednoOfP=prop.getProperty("noOfPassengers");
		if(noOfPassengers.equalsIgnoreCase(expectednoOfP))
		{
			//Extentreports method
			logger.pass("Number of passengers matches as expected");
			//Log4jMethod
			log.info("Number of passengers matches as expected");
			Assert.assertTrue(true);
		}else {
			//Extentreports method
			logger.fail("Number of passengers does not match as expected");
			//Log4jMethod
			log.error("Number of passengers does not match as expected");
			Assert.assertTrue(false);
		}
		
		}
		}
	}
	
	public void bloggerSocailLink() {
		logger=reporte.createTest("Validating the card title displayed in blogger");
		fpo=new footerPageObjects(driver);
		String parent=driver.getWindowHandle();
		fpo.bloggerSocialLink().click();
		Set<String>s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
				driver.switchTo().window(child_window);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				String card_Title=fpo.card_title().getText();
				System.out.println(card_Title);
				String expected_CardTitle=prop.getProperty("card_title");
				System.out.println(expected_CardTitle);
				if(card_Title.equalsIgnoreCase(expected_CardTitle))
				{
					//Extentreports method
					logger.pass("The card title displayed matches as expected");
					//Log4jMethod
					log.info("The card title displayed matches as expected");
					Assert.assertTrue(true);
				}else {
					//Extentreports method
					logger.fail("The card title displayed does not match as expected");
					//Log4jMethod
					log.error("The card title displayed does not match as expected");
					Assert.assertTrue(false);
				}
			}
		}
	}
}
