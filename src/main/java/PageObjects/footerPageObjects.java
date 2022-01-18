package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class footerPageObjects {
	public WebDriver driver;
	
	//Contact Us Page
	By contactUsLink=By.xpath("//a[@routerlink='/contact-us']");
	By contactUsemail=By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/app-contact-us/div[3]/div/div[1]/div[1]/div[2]/p/a/span");
	
	//Corporate car rental
	By boggerSocialLink=By.xpath("//a[@href='https://blog.savaari.com']");
	By card_title=By.xpath("//div/header/h2/a[@href='https://blog.savaari.com/travel-magazine-2022/']");
	
	//About Us Page
	By aboutUsLink=By.xpath("//a[@routerlink='/aboutus']");
	By ceoname=By.xpath("//div[@class='ceoName']");
	
	//Sitemap-Cab type page
	By sitemapLink=By.xpath("//a[@routerlink='/sitemap']");
	By cabTypeLink=By.xpath("//a[@routerlink='/cab-types']");
	By cabName=By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/app-home/div/app-seo-citylist/div/ul/li[11]/a");
	
	//Car rental in Cities
	By cityLink=By.xpath("//a[@href='/bangalore/car-rental']");
	By numberOfpassenger=By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[3]/div[2]/div/div[2]/div/table/tbody/tr[3]/td[3]/p");
	
	//Constructor
	public footerPageObjects(WebDriver driver) {
		this.driver=driver;
	}
	
	//Contact Us Page
	public WebElement contactUsLink() {
		return driver.findElement(contactUsLink);
	}
	public WebElement contactUsemail() {
		return driver.findElement(contactUsemail);
	}
	
	//Blogger Social page
	public WebElement bloggerSocialLink() {
		return driver.findElement(boggerSocialLink);
	}
	public WebElement card_title() {
		return driver.findElement(card_title);
	}
	
	//About Us Page
	public WebElement aboutUsLink() {
		return driver.findElement(aboutUsLink);
	}
	public WebElement ceoname() {
		return driver.findElement(ceoname);
	}
	
	//Sitemap-Cab Type Page
	public WebElement sitemapLink() {
		return driver.findElement(sitemapLink);
	}
	public WebElement cabTypeLink() {
		return driver.findElement(cabTypeLink);
	}
	public WebElement cabName() {
		return driver.findElement(cabName);
	}
	
	//Car rental in Cities
	public WebElement cityLink() {
		return driver.findElement(cityLink);
	}
	public WebElement numberOfpassenger() {
		return driver.findElement(numberOfpassenger);
	}
	
}
