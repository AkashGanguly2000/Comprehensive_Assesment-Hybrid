package Utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.WebElement;


public class dateTimeHelper {
public static String getCurrentDateTime() {
		
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
		
		return customFormat.format(currentDate);
	}
public static String getCurrentDay() {
    //Create a Calendar Object
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    //Get Current Day as a number
    int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
    System.out.println("Today Int: " + todayInt + "\n");
    //Integer to String Conversion
    String todayStr = Integer.toString(todayInt);
    System.out.println("Today Str: " + todayStr + "\n");
    return todayStr;
}
public static String getCurrentDayPlus(int days) {
    LocalDate currentDate = LocalDate.now();
    int dayOfWeekPlus = currentDate.getDayOfWeek().plus(days).getValue();
    return Integer.toString(dayOfWeekPlus);
}
public static void clickGivenDay(List<WebElement> elementList, String day) {
    elementList.stream()
        .filter(element -> element.getText().contains(day))
        .findFirst()
        .ifPresent(WebElement::click);
//  for (WebElement cell : elementList) {
//        String cellText = cell.getText();
//        if (cellText.contains(day)) {
//        	JavascriptExecutor executor = (JavascriptExecutor)driver;
//        	executor.executeScript("arguments[0].click();", cell);
//            break;
//        }
//    }
}
}
