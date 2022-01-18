package uiRepositories;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import PageObjects.loginPageObjects;
import PageObjects.navigateClass;
import ReusableComponents.dataDriven;
import ReusableComponents.driverConfig;

public class loginPageUI extends driverConfig{
	public ExtentReports reporte;
	public ExtentTest logger;
	
	public WebDriver driver;
	public static dataDriven excelutils=new dataDriven();
	
	private static Logger log = Logger.getLogger(loginPageUI.class);
	
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
	
	public loginPageObjects lpo;
	
	public void agentLogin() throws InterruptedException {
		logger=reporte.createTest("Validating the agent login with data");
		lpo=new loginPageObjects(driver);
		String parent=driver.getWindowHandle();
		lpo.agentButton().click();
		Set<String>s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
		String child_window=I1.next();
		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		lpo.agentLogin().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement email= lpo.agentEmail();
		WebElement pass=lpo.agentPassword();
		email.sendKeys(excelutils.getCellData(1, 1));
		pass.sendKeys(excelutils.getCellData(2, 1));
		lpo.agentSubmit().click();
		Thread.sleep(5000);
		String message=lpo.agentLoginMessage().getText();
		if(message != null)
		{
			//Extentreports method
			logger.pass("Data validated and appropriate message displayed");
			//Log4jMethod
			log.info("Data validated and appropriate message displayed");
			Assert.assertTrue(true);
		}else {
			//Extentreports method
			logger.fail("Data validated but appropriate message not displayed");
			//Log4jMethod
			log.error("Data validated but appropriate message not displayed");
			Assert.assertTrue(false);
		}
		}
		}
	}
	
	public void customerLogin() throws InterruptedException {
		logger=reporte.createTest("Validating the customer login with data");
		lpo=new loginPageObjects(driver);
		lpo.signInButton().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement email= lpo.customerEmail();
		WebElement pass=lpo.customerPassword();
		email.sendKeys(excelutils.getCellData(3, 1));
		pass.sendKeys(excelutils.getCellData(4, 1));
		lpo.customerSubmit().click();
		Thread.sleep(5000);
		String message=lpo.customerLoginMessage().getText();
		if(message != null)
		{
			//Extentreports method
			logger.pass("Customer Data validated and appropriate message displayed");
			//Log4jMethod
			log.info("Customer Data validated and appropriate message displayed");
			Assert.assertTrue(true);
		}else {
			//Extentreports method
			logger.fail("Customer Data validated but appropriate message not displayed");
			//Log4jMethod
			log.error("Customer Data validated but appropriate message not displayed");
			Assert.assertTrue(false);
		}
	}
	
	public void forgotPassword() throws InterruptedException {
		logger=reporte.createTest("Validating the customer forgot password with data");
		lpo=new loginPageObjects(driver);
		lpo.signInButton().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		lpo.customerForgotlink().click();
		WebElement email= lpo.customerForgotEmail();
		email.sendKeys(excelutils.getCellData(3, 1));
		lpo.resetPasswordButton().click();
		Thread.sleep(5000);
		String message=lpo.customerForgotMessage().getText();
		if(message != null)
		{
			//Extentreports method
			logger.pass("Customer-forgot password Data validated and appropriate message displayed");
			//Log4jMethod
			log.info("Customer-forgot password Data validated and appropriate message displayed");
			Assert.assertTrue(true);
		}else {
			//Extentreports method
			logger.fail("Customer-forgot password Data validated but appropriate message not displayed");
			//Log4jMethod
			log.error("Customer-forgot password Data validated but appropriate message not displayed");
			Assert.assertTrue(false);
		}
	}
}
