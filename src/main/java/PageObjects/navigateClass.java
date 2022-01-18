package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;

public class navigateClass {
	
	By jsClick=By.xpath("/html/body/w-div/span[2]");

	WebDriver driver;
	public navigateClass(WebDriver driver) {
		this.driver=driver;
	}
	
	public Navigation navigate() {
		return driver.navigate();
	}
	public WebElement jsClick() {
		return driver.findElement(jsClick);
	}

}
