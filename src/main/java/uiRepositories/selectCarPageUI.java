package uiRepositories;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import PageObjects.navigateClass;
import PageObjects.selectCarObjects;
import ReusableComponents.dataDriven;
import ReusableComponents.driverConfig;
import Utilities.dateTimeHelper;

public class selectCarPageUI extends driverConfig{
	
	public ExtentReports reporte;
	public ExtentTest logger;
	
	public WebDriver driver;
	public static dataDriven excelutils=new dataDriven();
	private static Logger log = Logger.getLogger(selectCarPageUI.class);
	
	public void siteNavigation(ExtentReports rep) throws IOException {
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
		excelutils.setExcelFile(prop.getProperty("Sheet_Name"));
	}
	
	public selectCarObjects sco;
	public Actions action;
	public WebElement optionsList;
	public List<WebElement> options;
	public List<WebElement> columns;
	public String date;
	public void oneWayBooking() throws InterruptedException {
		logger=reporte.createTest("Validating the one way booking-outstation");
		sco=new selectCarObjects(driver);
		WebElement radioelement=sco.oneWayradio();
		Actions actions = new Actions(driver);
		actions.moveToElement(radioelement).click().build().perform();
		WebElement from=sco.fromLocation();
		from.sendKeys(excelutils.getCellData(5, 1));
		action = new Actions(driver);    
		optionsList = sco.dropdownOption();
		action.moveToElement(optionsList);
		options = sco.dropdownList() ;
		for(int i=0;i<options.size();i++) {
		    if (i==0) {
		        options.get(i).click();
		    }
		}
		action=null;
		optionsList=null;
		options=null;
		WebElement to=sco.toLocation();
		to.sendKeys(excelutils.getCellData(6, 1));
		action = new Actions(driver);    
		optionsList = sco.dropdownOption();
		action.moveToElement(optionsList);
		options = sco.dropdownList() ;
		for(int i=0;i<options.size();i++) {
		    if (i==0) {
		        options.get(i).click();
		    }
		}
		sco.fromDatePicker().click();
		WebDriverWait wait=new WebDriverWait(driver, 1000);
		WebElement dateWidgetFrom = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sco.fromDateMain())).get(0);
		columns = dateWidgetFrom.findElements(sco.dateData());
		Thread.sleep(2000);
		date=prop.getProperty("selectcarDate");
		dateTimeHelper.clickGivenDay(columns, date);
		Select select = new Select(sco.pickupTime());
		Thread.sleep(2000);
		select.selectByIndex(5);
		sco.bookButton().click();
		options=null;
		options=sco.getPriceList();
		String price=null;
		for(int i=0;i<options.size();i++)
		{
			if(i==1){ price=options.get(i).getText();}
		}
		Thread.sleep(2000);
		if(price!=null)
		{
			//Extentreports method
			logger.pass("One way price data validated");
			//Log4jMethod
			log.info("One way price data validated");
			Assert.assertTrue(true);
		}else {
			//Extentreports method
			logger.fail("One way price data not validated");
			//Log4jMethod
			log.info("One way price data not validated");
			Assert.assertTrue(false);
		}
	}
	
	public void roundTripBooking() throws InterruptedException {
		logger=reporte.createTest("Validating the round trip booking-outstation");
		sco=new selectCarObjects(driver);
		WebElement radioelement=sco.roundTripradio();
		Actions actions = new Actions(driver);
		actions.moveToElement(radioelement).click().build().perform();
		WebElement from=sco.fromLocation();
		from.sendKeys(excelutils.getCellData(5, 1));
		action = new Actions(driver);    
		optionsList = sco.dropdownOption();
		action.moveToElement(optionsList);
		options = sco.dropdownList() ;
		for(int i=0;i<options.size();i++) {
		    if (i==0) {
		        options.get(i).click();
		    }
		}
		action=null;
		optionsList=null;
		options=null;
		WebElement to=sco.toLocation();
		to.sendKeys(excelutils.getCellData(7, 1));
		action = new Actions(driver);    
		optionsList = sco.dropdownOption();
		action.moveToElement(optionsList);
		options = sco.dropdownList() ;
		for(int i=0;i<options.size();i++) {
		    if (i==0) {
		        options.get(i).click();
		    }
		}
		sco.fromDatePicker().click();
		WebDriverWait wait=new WebDriverWait(driver, 1000);
		WebElement dateWidgetFrom = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sco.fromDateMain())).get(0);
		columns = dateWidgetFrom.findElements(sco.dateData());
		Thread.sleep(2000);
		date=prop.getProperty("selectcarDate");
		dateTimeHelper.clickGivenDay(columns, date);
		columns=null;
		sco.toDatePicker().click();
		WebElement dateWidgetTo = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sco.toDateMain())).get(0);
		columns = dateWidgetTo.findElements(sco.dateData());
		Thread.sleep(2000);
		String toDate=prop.getProperty("twoWayDate");
		dateTimeHelper.clickGivenDay(columns, toDate);
		Select select = new Select(sco.pickupTime());
		Thread.sleep(2000);
		select.selectByIndex(7);
		sco.bookButton().click();
		options=null;
		options=sco.getPriceList();
		String price=null;
		for(int i=0;i<options.size();i++)
		{
			if(i==1){ price=options.get(i).getText();}
		}
		Thread.sleep(2000);
		if(price!=null)
		{
			//Extentreports method
			logger.pass("Round trip price data validated");
			//Log4jMethod
			log.info("Round trip price data validated");
			Assert.assertTrue(true);
		}else {
			//Extentreports method
			logger.fail("Round trip price data not validated");
			//Log4jMethod
			log.info("Round trip price data not validated");
			Assert.assertTrue(false);
		}
	}
	
	public void localBooking() throws InterruptedException {
		logger=reporte.createTest("Validating the local trip booking");
		sco=new selectCarObjects(driver);
		sco.localOption().click();
		WebElement pickupPoint=sco.fromLocation();
		pickupPoint.sendKeys(excelutils.getCellData(5, 1));
		action = new Actions(driver);    
		optionsList = sco.dropdownOption();
		action.moveToElement(optionsList);
		options = sco.dropdownList() ;
		for(int i=0;i<options.size();i++) {
		    if (i==0) {
		        options.get(i).click();
		    }
		}
		sco.localDatePicker().click();
		WebDriverWait wait=new WebDriverWait(driver, 1000);
		WebElement dateWidgetpickup = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sco.localDateMain())).get(0);
		columns = dateWidgetpickup.findElements(sco.dateData());
		Thread.sleep(2000);
		String localBookingdate=prop.getProperty("localBookingDate");
		Actions action=new Actions(driver);
		action.moveToElement(sco.localmoveElement());
			dateTimeHelper.clickGivenDay(columns, localBookingdate);
			Select select = new Select(sco.pickupTime());
			Thread.sleep(2000);
			select.selectByVisibleText(prop.getProperty("localtime"));
			sco.bookButton().click();
			options=sco.getPriceList();
			String price=null;
			for(int i=0;i<options.size();i++)
			{
				if(i==1){ price=options.get(i).getText();}
			}
			Thread.sleep(2000);
			if(price!=null)
			{
				//Extentreports method
				logger.pass("Local trip price data validated");
				//Log4jMethod
				log.info("Local trip price data validated");
				Assert.assertTrue(true);
			}else {
				//Extentreports method
				logger.fail("Local trip price data not validated");
				//Log4jMethod
				log.info("Local trip price data not validated");
				Assert.assertTrue(false);
			}
	}
	
	public void cabtoAirportBooking() throws InterruptedException {
		logger=reporte.createTest("Validating the Cab to the airport booking");
		sco=new selectCarObjects(driver);
		sco.airportOption().click();
		WebElement city=sco.fromLocation();
		city.sendKeys(excelutils.getCellData(5, 1));
		action = new Actions(driver);    
		optionsList = sco.dropdownOption();
		action.moveToElement(optionsList);
		options = sco.dropdownList() ;
		for(int i=0;i<options.size();i++) {
		    if (i==0) {
		        options.get(i).click();
		    }
		}
		Select select = new Select(sco.tripOption());
		Thread.sleep(2000);
		select.selectByIndex(2);
		action=null;
		optionsList=null;
		options=null;
		WebElement pickupAddress=sco.pickupAddress();
		pickupAddress.sendKeys(excelutils.getCellData(8, 1));
		Thread.sleep(5000);
		action = new Actions(driver);    
		optionsList = sco.airportDropdownOption();
		action.moveToElement(optionsList);
		options = sco.airportDropdownList();
		for(int i=0;i<options.size();i++) {
		    if (i==0) {
		        options.get(i).click();
		    }
		}
		sco.pickupDate().click();
		WebDriverWait wait=new WebDriverWait(driver, 1000);
		WebElement dateWidgetpickup = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sco.pickupDateMain())).get(0);
		columns = dateWidgetpickup.findElements(sco.dateData());
		Thread.sleep(2000);
		date=prop.getProperty("selectcarDate");
		dateTimeHelper.clickGivenDay(columns, date);
		Select select1 = new Select(sco.pickupTime());
		Thread.sleep(2000);
		select1.selectByVisibleText(prop.getProperty("cabAirporttime"));
		sco.bookButton().click();
		options=sco.getPriceList();
		String price=null;
		for(int i=0;i<options.size();i++)
		{
			if(i==1){ price=options.get(i).getText();}
		}
		Thread.sleep(2000);
		if(price!=null)
		{
			//Extentreports method
			logger.pass("Cab to the airport trip price data validated");
			//Log4jMethod
			log.info("Cab to the airport trip price data validated");
			Assert.assertTrue(true);
		}else {
			//Extentreports method
			logger.fail("Cab to the airport trip price data not validated");
			//Log4jMethod
			log.info("Cab to the airport trip price data not validated");
			Assert.assertTrue(false);
		}
	}
	
	public void cabFromAirportBooking() throws InterruptedException {
		logger=reporte.createTest("Validating the Cab from the airport booking");
		sco=new selectCarObjects(driver);
		sco.airportOption().click();
		WebElement city=sco.fromLocation();
		city.sendKeys(excelutils.getCellData(5, 1));
		action = new Actions(driver);    
		optionsList = sco.dropdownOption();
		action.moveToElement(optionsList);
		options = sco.dropdownList() ;
		for(int i=0;i<options.size();i++) {
		    if (i==0) {
		        options.get(i).click();
		    }
		}
		Select select = new Select(sco.tripOption());
		Thread.sleep(2000);
		select.selectByIndex(1);
		action=null;
		optionsList=null;
		options=null;
		WebElement dropAddress=sco.pickupAddress();
		dropAddress.sendKeys(excelutils.getCellData(8, 1));
		Thread.sleep(5000);
		action = new Actions(driver);    
		optionsList = sco.airportDropdownOption();
		action.moveToElement(optionsList);
		options = sco.airportDropdownList();
		for(int i=0;i<options.size();i++) {
		    if (i==0) {
		        options.get(i).click();
		    }
		}
		sco.pickupDate().click();
		WebDriverWait wait=new WebDriverWait(driver, 1000);
		WebElement dateWidgetpickup = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sco.pickupDateMain())).get(0);
		columns = dateWidgetpickup.findElements(sco.dateData());
		Thread.sleep(2000);
		String cabfromdate=prop.getProperty("cabfromAiportDate");
		dateTimeHelper.clickGivenDay(columns, cabfromdate);
		Select select1 = new Select(sco.pickupTime());
		Thread.sleep(2000);
		select1.selectByVisibleText(prop.getProperty("cabAirporttime"));
		sco.bookButton().click();
		options=sco.getPriceList();
		String price=null;
		for(int i=0;i<options.size();i++)
		{
			if(i==1){ price=options.get(i).getText();}
		}
		Thread.sleep(2000);
		if(price!=null)
		{
			//Extentreports method
			logger.pass("Cab from the airport trip price data validated");
			//Log4jMethod
			log.info("Cab from the airport trip price data validated");
			Assert.assertTrue(true);
		}else {
			//Extentreports method
			logger.fail("Cab from the airport trip price data not validated");
			//Log4jMethod
			log.info("Cab from the airport trip price data not validated");
			Assert.assertTrue(false);
		}
	}
}
