import java.io.File;
import org.openqa.selenium.support.ui.Select;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import io.netty.channel.unix.Errors;

import java.util.ArrayList;

public class Page_Reload {
	static String currentGoldBalance;
	static String transStatus;
	static String transNumber;
	static String newGoldBalance;
	static String browser;
	static String paymentChannel;
	static String reloadAmount;
	static Class<?> cls;
	static Object obj;
	static String errorMessage;
	static String line;
	public static void reload(String paymentChannelFromExcel, String channelLocator, String reloadAmountFromExcel, String className, WebDriver driver) throws InterruptedException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		reloadAmount = reloadAmountFromExcel;
		paymentChannel = paymentChannelFromExcel;
		transNumber = "null";
		try {		
			
		    browser = new Exception().getStackTrace()[1].getClassName(); 
		    cls = Class.forName(browser);
		    obj = cls.newInstance();	
		    String class_name = cls.getName();
		    System.out.println("This is " + class_name + " calling");
			Thread.sleep(7000);
			driver.findElement(By.xpath("/html/body/div[1]/nav/div/ul/li[1]/a")).click(); //click on reload link with the + sign on Gold Web
			Thread.sleep(3000);
			currentBalance(driver);
			//driver.findElement(By.xpath(channelLocator)).click(); //click on payment channel
			//String title = "Visa";
			Thread.sleep(5000);
			line = "77"; 
			driver.findElement(By.cssSelector("[title^='"+paymentChannel+"']")).click(); //click on payment channel
			Thread.sleep(3000);
			line = "81";
			driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div/div[2]/div/input")).sendKeys(reloadAmount); //key in amount
			//if (reloadAmount. "6.0")
			line = "84";
			driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div/div/div[2]/div[2]/div/div[2]/div[3]/div/a[1]")).click(); //click on Next buttmn
			Thread.sleep(5000);
			line = "87";
			if(paymentChannel.contains("Visa")) {
				driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[4]/div[1]/form/fieldset[1]/div[1]/p[1]/input")).sendKeys("4111111111111111"); // key in card number
			}
			else {
				driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[4]/div[1]/form/fieldset[1]/div[1]/p[1]/input")).sendKeys("5105105105105100"); // key in card number
			}
			driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[4]/div[1]/form/fieldset[1]/div[1]/p[2]/input")).sendKeys("QA Tester"); //key in cardholder name
			driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[4]/div[1]/form/fieldset[1]/div[2]/p/span[3]/input[1]")).sendKeys("01"); // key in exp Month
			driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[4]/div[1]/form/fieldset[1]/div[2]/p/span[3]/input[2]")).sendKeys("30"); //key in exp year
			driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[4]/div[1]/form/fieldset[1]/div[2]/div/p/span[1]/span/input")).sendKeys("123"); //key in sec code
			driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[4]/div[1]/form/div[2]/div/input")).click(); //click Make Payment
			Thread.sleep(10000);
			transNumber = driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div/div/div/div[1]/div/div/div[7]/div[2]/span")).getText(); //get Trans Number
			System.out.println("Transaction result is " + transNumber);
			transStatus = driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div/div/div/div[1]/div/div/div[8]/div[2]/span")).getText(); // Get trans status
			System.out.println("Transaction result is " + transStatus);
			newBalance(driver);
			errorMessage = "No error";
			}//try
		catch(ElementNotVisibleException | ElementNotSelectableException | NoSuchElementException | ElementClickInterceptedException e) {
			Thread.sleep(5000);
			String errorMsg = e.getMessage();
			if(errorMsg.contains("no such element")) {
				errorMessage = "No such element: Unable to locate element";
			}
			else {
			System.out.println("Error : " + e.getMessage());
			errorMessage = "Some other error";
			}
			System.out.println("Error at page " + driver.getCurrentUrl());
			System.out.println("Error at line = " + line);
			errors(driver);			
		}//catch
		//returnToTestCase(cls);
		System.out.println("Payment Channel = " +paymentChannel );
		System.out.println("Reload Amount  = " +reloadAmount );
		System.out.println("Current balance = " +currentGoldBalance );
		System.out.println("New balance = " +newGoldBalance );
		System.out.println("Transaction Status = " +transStatus );
		System.out.println("Transaction No.  = " +transNumber );
		System.out.println("errorMessage = " +errorMessage );
		line = "122";
		Class[] arg = new Class[7];
	    arg[0] = String.class; //gameName
	    arg[1] = String.class; //address
	    arg[2] = String.class; //test_data
	    arg[3] = String.class; //common_data_tab	
	    arg[4] = String.class;
	    arg[5] = String.class;
	    arg[6] = String.class;
	    Method method = cls.getDeclaredMethod("Verify", arg[0],arg[1],arg[2],arg[3], arg[4], arg[5], arg[6]);
		method.invoke(obj, paymentChannel, reloadAmount, currentGoldBalance, newGoldBalance, transStatus, transNumber, errorMessage);
	}//reload
	public static void currentBalance(WebDriver driver) {
		currentGoldBalance = driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div/div/div[2]/div[1]/div/div/div/div/div/div[2]/div/div[1]/div[2]/span")).getText();
	    System.out.println("Current Gold balance = " + currentGoldBalance);
	}// currentBalance
	public static void newBalance(WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		newGoldBalance = driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div/div/div/div[2]/div/div/div/div[2]/div/div[1]/div[2]/span")).getText();
		System.out.println("Current Gold balance = " + newGoldBalance);
	}
	public static void errors(WebDriver driver) {
		
	}
	public static void returnToTestCase(Class cls) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Class[] arg = new Class[6];
	    arg[0] = String.class; //gameName
	    arg[1] = String.class; //address
	    arg[2] = String.class; //test_data
	    arg[3] = String.class; //common_data_tab	
	    arg[4] = String.class;
	    arg[5] = String.class;
	    arg[6] = String.class;
	    Method method = cls.getDeclaredMethod("Verify", arg[0],arg[1],arg[2],arg[3], arg[4], arg[5], arg[6]);
		method.invoke(obj, paymentChannel, reloadAmount, currentGoldBalance, newGoldBalance, transStatus, transNumber, errorMessage);
	}
}
