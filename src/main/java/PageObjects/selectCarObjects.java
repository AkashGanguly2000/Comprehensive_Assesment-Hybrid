package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class selectCarObjects {
	
	public WebDriver driver;
	
	//Cab Booking-Commons
	By fromLocation=By.xpath("//input[@id='fromCityList']");
	By toLocation=By.xpath("//input[@class='form-control ng-untouched ng-pristine ng-invalid']");
	By dropdownOption=By.xpath("//*[@class='dropdown-menu show ng-star-inserted']");
	By dropdownList=By.xpath("//button[@role='option']");
	By fromDatePicker=By.xpath("//input[@class='ng-tns-c75-1 form-control p-inputtext p-component ng-star-inserted']");
	By fromDateMain=By.xpath("//table[@class='p-datepicker-calendar ng-tns-c75-1']");
	By pickupTime=By.id("pickUpTime");
	By dateData=By.tagName("td");
	By bookButton=By.xpath("//button[@class='book-button btn']");
	By getCarList=By.xpath("//span[@class='ng-star-inserted']");
	By getPriceList=By.xpath("//span[@class='text-right carPrice pricetag']");
	
	//OutStation Booking
	//One way Booking
	By oneWayradio=By.xpath("//input[@id='oneway_radio']");
	
	//Round Trip Booking
	By roundTripradio=By.xpath("//input[@id='out_radio']");
	By toDatePicker=By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[1]/div[1]/div[2]/app-outstation/div/form/div[3]/div[2]/div/p-calendar[1]/span/input");
	By toDateMain=By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[1]/div[1]/div[2]/app-outstation/div/form/div[3]/div[2]/div/p-calendar[1]/span/div/div/div/div[2]/table");
	
	//Local Booking
	By localoption=By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[1]/div[1]/div[1]/div[2]/a");
	By localDatePicker=By.xpath("//input[@placeholder='dd-mm-yyyy']");
	By localDateMain=By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[1]/div[1]/div[2]/app-local/div/form/div[2]/div/div/p-calendar[1]/span/div/div/div/div[2]/table");
	By moveLocalElement=By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[1]/div[1]/div[2]/app-local/div/form/div[2]/div/div/p-calendar[1]/span/div/div/div/div[2]/table");
	//Airport Booking
	By airportoption=By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[1]/div[1]/div[1]/div[3]/a");
	By tripOption=By.xpath("//select[@formcontrolname='frmLocalSubTripType']");
	By pickupAddress=By.id("search_places");
	By airportDropdown=By.xpath("//*[@class='custom-autocomplete__dropdown ng-star-inserted']");
	By airportDropdownList=By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[1]/div[1]/div[2]/app-local/div/form/div[3]/div/div/ng4geo-autocomplete/div/ul/li[1]/a");
	By pickupDate=By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[1]/div[1]/div[2]/app-local/div/form/div[4]/div[1]/div/p-calendar[1]/span/input");
	By pickupDateMain=By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[1]/div[1]/div[2]/app-local/div/form/div[4]/div[1]/div/p-calendar[1]/span/div/div/div/div[2]/table");
	
	//Constructor
	public selectCarObjects(WebDriver driver) {
		this.driver=driver;
	}
	
	//Cab Booking Commons
	public WebElement fromLocation() {
		return driver.findElement(fromLocation);
	}
	public WebElement toLocation() {
		return driver.findElement(toLocation);
	}
	public WebElement dropdownOption() {
		return driver.findElement(dropdownOption);
	}
	public List<WebElement> dropdownList() {
		return driver.findElements(dropdownList);
	}
	public WebElement fromDatePicker() {
		return driver.findElement(fromDatePicker);
	}
	public By fromDateMain() {
		return fromDateMain;
	}
	public WebElement pickupTime() {
		return driver.findElement(pickupTime);
	}
	public By dateData() {
		return dateData;
	}
	public WebElement bookButton() {
		return driver.findElement(bookButton);
	}
	public List<WebElement> getCarList() {
		return driver.findElements(getCarList);
	}
	public List<WebElement> getPriceList() {
		return driver.findElements(getPriceList);
	}
	
	//OutStation Booking
	//One Way Booking
	public WebElement oneWayradio() {
		return driver.findElement(oneWayradio);
	}
	//Round Trip Booking
	public WebElement toDatePicker() {
		return driver.findElement(toDatePicker);
	}
	public WebElement roundTripradio() {
		return driver.findElement(roundTripradio);
	}
	public By toDateMain() {
		return toDateMain;
	}
	
	//Local Booking
	public WebElement localOption() {
		return driver.findElement(localoption);
	}
	public WebElement localDatePicker() {
		return driver.findElement(localDatePicker);
	}
	public By localDateMain() {
		return localDateMain;
	}
	public WebElement localmoveElement() {
		return driver.findElement(moveLocalElement);
	}
	
	//Airport Booking
	public WebElement airportOption() {
		return driver.findElement(airportoption);
	}
	public WebElement tripOption() {
		return driver.findElement(tripOption);
	}
	public WebElement pickupAddress() {
		return driver.findElement(pickupAddress);
	}
	public WebElement airportDropdownOption() {
		return driver.findElement(airportDropdown);
	}
	public List<WebElement> airportDropdownList() {
		return driver.findElements(airportDropdownList);
	}
	public WebElement pickupDate() {
		return driver.findElement(pickupDate);
	}
	public By pickupDateMain() {
		return pickupDateMain;
	}
	
}
