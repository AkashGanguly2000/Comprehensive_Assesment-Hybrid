package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePageObjects {
	public WebDriver driver;
	By text=By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[2]/div[1]/div/div[3]/div[1]");
	
	public homePageObjects(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement validateText() {
		return driver.findElement(text);
	}
}
