package TestOperations;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import ReusableComponents.driverConfig;
import ReusableComponents.extentReports;
import uiRepositories.footerPageUI;
import uiRepositories.homePageUI;
import uiRepositories.loginPageUI;
import uiRepositories.selectCarPageUI;

public class testRunner extends driverConfig{
	public ExtentReports report;
	public homePageUI hpi=new homePageUI();
	public loginPageUI lpi=new loginPageUI();
	public selectCarPageUI scpi=new selectCarPageUI();
	public footerPageUI fpi=new footerPageUI();
	static ExtentReports extent = extentReports.ExtentReports();
	
	@BeforeMethod
	public ExtentReports reports() throws IOException, InterruptedException {
		ExtentReports rep=extent;
		return rep;
	}
	
	@Test(priority=1)
	public void homePageGetTitle() throws IOException, InterruptedException {
		report=reports();
		hpi.siteNavigation(report);
		hpi.getTitle();
	}
	@Test(priority=2)
	public void homePageElement() throws IOException, InterruptedException {
		report=reports();
		hpi.siteNavigation(report);
		hpi.validPageElement();
	}
	@Test(priority=3)
	public void validAgentDetails() throws InterruptedException, IOException {
		report=reports();
		lpi.siteNavigation(report);
		lpi.agentLogin();
	}
	@Test(priority=4)
	public void validcustomerLoginDetails() throws InterruptedException, IOException {
		report=reports();
		lpi.siteNavigation(report);
		lpi.customerLogin();
	}
	@Test(priority=5)
	public void validforgotPasswordDetails() throws InterruptedException, IOException {
		report=reports();
		lpi.siteNavigation(report);
		lpi.forgotPassword();
	}
	@Test(priority=6)
	public void validonewayBooking() throws InterruptedException, IOException {
		report=reports();
		scpi.siteNavigation(report);
		scpi.oneWayBooking();
	}
	@Test(priority=7)
	public void validroundtripBooking() throws InterruptedException, IOException {
		report=reports();
		scpi.siteNavigation(report);
		scpi.roundTripBooking();
	}
	/*@Test(priority=8)
	public void validlocalTripBooking() throws InterruptedException, IOException {
		report=reports();
		scpi.siteNavigation(report);
		scpi.localBooking();
	}*/
	@Test(priority=9)
	public void validFromAirportTripBooking() throws InterruptedException, IOException {
		report=reports();
		scpi.siteNavigation(report);
		scpi.cabFromAirportBooking();
	}
	@Test(priority=10)
	public void validToAirportTripBooking() throws InterruptedException, IOException {
		report=reports();
		scpi.siteNavigation(report);
		scpi.cabtoAirportBooking();
	}
	@Test(priority=11)
	public void validContactDetails() throws IOException, InterruptedException {
		report=reports();
		fpi.siteNavigation(report);
		fpi.contactUs();
	}
	@Test(priority=12)
	public void validbloggerSocialLinkDetails() throws IOException, InterruptedException {
		report=reports();
		fpi.siteNavigation(report);
		fpi.bloggerSocailLink();
	}
	@Test(priority=13)
	public void validAboutDetails() throws IOException, InterruptedException {
		report=reports();
		fpi.siteNavigation(report);
		fpi.aboutUs();
	}
	@Test(priority=14)
	public void validcabTypeDetails() throws InterruptedException, IOException {
		report=reports();
		fpi.siteNavigation(report);
		fpi.siteMapCabType();
	}
	@Test(priority=15)
	public void validcarRentalDetails() throws InterruptedException, IOException {
		report=reports();
		fpi.siteNavigation(report);
		fpi.carRentalCitiies();
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	@AfterSuite
	public void reportClose() {
		report.flush();
	}
}
