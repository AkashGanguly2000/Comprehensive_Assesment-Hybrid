package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPageObjects {
	public WebDriver driver;
	
	//Agent Login
	By agentButton=By.xpath("//a[@href='https://www.b2bcab.in/']");
	By agentLogin=By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/app-landing-page/div/div[3]/div/div[1]/button/div");
	By agentEmail=By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/app-landing-page/div/div[5]/div/div[2]/form/input[1]");
	By agentPassword=By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/app-landing-page/div/div[5]/div/div[2]/form/input[2]");
	By agentSubmit=By.xpath("//*[@id='login1']");
	By agentLoginMessage=By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/app-landing-page/div/div[5]/div/div[2]/form/div[3]/div");
	
	//Customer Login
	By signInButton=By.xpath("//a[@class='col-auto user_login pl-1 pl-md-2 pr-0 ng-star-inserted']");
	By customerEmail=By.xpath("//input[@type='email']");
	By customerPassword=By.xpath("//input[@type='password']");
	By customerSubmit=By.xpath("/html/body/app-root/app-navbar/div[2]/div/div[2]/form/div[2]/button[1]");
	By customerLoginMessage=By.xpath("/html/body/app-root/app-navbar/div[2]/div/div[2]/form/div[3]/div");
	
	//Customer Forgot Password
	By customerForgotlink=By.xpath("/html/body/app-root/app-navbar/div[2]/div/div[2]/form/div[1]/a");
	By customerForgotEmail=By.xpath("/html/body/app-root/app-navbar/div[2]/div/div[2]/form/input");
	By resetPasswordButton=By.xpath("//button[@class='theme-button margin-left-5px forgot-password-button']");
	By customerForgotMessage=By.xpath("/html/body/app-root/app-navbar/div[2]/div/div[2]/form/div[2]/div");
	
	//Constructor
	public loginPageObjects(WebDriver driver) {
		this.driver=driver;
	}
	
	//Agent Login
	public WebElement agentButton() {
		return driver.findElement(agentButton);
	}
	public WebElement agentLogin() {
		return driver.findElement(agentLogin);
	}
	public WebElement agentEmail() {
		return driver.findElement(agentEmail);
	}
	public WebElement agentPassword() {
		return driver.findElement(agentPassword);
	}
	public WebElement agentSubmit() {
		return driver.findElement(agentSubmit);
	}
	public WebElement agentLoginMessage() {
		return driver.findElement(agentLoginMessage);
	}
	
	//Customer Login
	public WebElement signInButton() {
		return driver.findElement(signInButton);
	}
	public WebElement customerEmail() {
		return driver.findElement(customerEmail);
	}
	public WebElement customerPassword() {
		return driver.findElement(customerPassword);
	}
	public WebElement customerSubmit() {
		return driver.findElement(customerSubmit);
	}
	public WebElement customerLoginMessage() {
		return driver.findElement(customerLoginMessage);
	}
	
	//Customer Forgot Password
	public WebElement customerForgotlink() {
		return driver.findElement(customerForgotlink);
	}
	public WebElement customerForgotEmail() {
		return driver.findElement(customerForgotEmail);
	}
	public WebElement resetPasswordButton() {
		return driver.findElement(resetPasswordButton);
	}
	public WebElement customerForgotMessage() {
		return driver.findElement(customerForgotMessage);
	}
	
	
}
