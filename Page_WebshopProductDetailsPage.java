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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;


public class Page_WebshopProductDetailsPage {
	static int error;
	static String line;
	static String clickBox;
	static String balanceAfter;
	static String balanceBefore;
	static String productPrice;
	static String className;
	static String browser;
	static String successMessage; 
	static String productPriceWithoutCurrency;
	            
	public static void WebshopProductDetailsPage(String gameName, String userid, String serverid, String deno, String paymentChannel, String save_details, String className, String testCase, WebDriver driver) throws InterruptedException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		
		Class[] arg = new Class[8];
	    arg[0] = String.class; //gameName
	    arg[1] = String.class; //address
	    arg[2] = String.class; //test_data
	    arg[3] = String.class; //common_data_tab
	    arg[4] = String.class; //TC_data_tab
	    arg[5] = String.class; //test_result
	    arg[6] = String.class;
	    arg[7] = String.class;
	    browser = new Exception().getStackTrace()[1].getClassName(); 
	    Class<?> cls = Class.forName(browser);
	    Object obj = cls.newInstance();	
	    String class_name = cls.getName();
	    System.out.println("This is " + class_name + " calling");	    
	    error = 0;
		do {
			try {
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				line = "80";
				driver.findElement(By.xpath("/html/body/div[1]/nav/div/ul/li[2]/a/span")).click(); // click on Search button
				driver.findElement(By.xpath("//*[@placeholder='Search']")).sendKeys(gameName); //enter product name
				driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div[2]/a")).click(); //click on returned item due to search
				switch (gameName) { 
				   case "MU Origin 2":
					   Thread.sleep(5000);
						 driver.findElement(By.xpath("/html/body/div[1]/nav/div/ul/li[4]/form/ul/li/a/div/img")).click(); //click to view profile
						 beforeBalance(driver); 
						 Thread.sleep(5000);
						 driver.findElement(By.name("Game User ID")).sendKeys(userid); //Enter User ID	
						 line = "MU 67";
						 driver.findElement(By.name("ServerId")).sendKeys(serverid); //EnterServerID
						 line = "MU 71";
						 driver.findElement(By.xpath("//*[contains(text(),'"+deno+"')]")).click(); // click deno
						 line = "MU 75";
						 driver.findElement(By.xpath(paymentChannel)).click(); //click payment channel
						 line = "MU 80";
						 driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div[2]/div[2]/div/div[4]/div[3]/div/div[2]")).click(); //click  to continue
						 line = "MU 88";
						 productPrice(driver);
						 line = "130";
						 Thread.sleep(5000);
	                     driver.findElement(By.xpath("/html/body/div[1]/main/section/div/div/div/div[5]/div/div[4]/form/button")).click();
	                     successMessage(driver);
	                     afterBalance(driver);
						 error = 1;
						 break;
				   case "Mobile Legends":
						 Thread.sleep(5000);  
						 driver.findElement(By.xpath("/html/body/div[1]/nav/div/ul/li[4]/form/ul/li/a/div/img")).click(); //click to view profile
						 beforeBalance(driver); 
						 Thread.sleep(5000);
						 driver.findElement(By.name("Game User ID")).sendKeys(userid); //Enter User ID	
						 line = "99";
						 driver.findElement(By.name("ServerId")).sendKeys(serverid); //EnterServerID
						 line = "103";
						 driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div/div/div[2]")).click();
						 line = "107";
						 driver.findElement(By.xpath(paymentChannel)).click(); //click payment channel
						 line = "111";
						 driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div[2]/div[2]/div/div[4]/div[3]/div/div[2]")).click(); //click  to continue
						 line = "123";
						 Thread.sleep(20000);
						 productPrice(driver);	
						 line = "130";
	                     driver.findElement(By.xpath("/html/body/div[1]/main/section/div/div/div/div[5]/div/div[4]/form/button")).click();
	                     afterBalance(driver);
						 error = 1;
						 break;
				   case "Bleach 3D":
						 Thread.sleep(5000);  
						 driver.findElement(By.xpath("/html/body/div[1]/nav/div/ul/li[4]/form/ul/li/a/div/img")).click(); //click to view profile
						 beforeBalance(driver); 
						 Thread.sleep(5000);
						 driver.findElement(By.name("Game User ID")).sendKeys(userid); //Enter User ID	
						 line = "99";	
						 driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div[2]/div[2]/div/div[1]/div[3]/div/div/div[2]/div/div/div/div[1]")).click(); //click to open drop downlist
						 driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div[2]/div[2]/div/div[1]/div[3]/div/div/div[2]/div/div/div")).sendKeys(serverid);
						 driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div[2]/div[2]/div/div[1]/div[3]/div/div/div[2]/div/div/div/div[3]")).click();
						 line = "103";
						 driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div/div/div[2]")).click();
						 line = "107";
						 driver.findElement(By.xpath(paymentChannel)).click(); //click payment channel
						 line = "111";
						 driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div[2]/div[2]/div/div[4]/div[3]/div/div[2]")).click(); //click  to continue
						 line = "123";
						 Thread.sleep(20000);
						 productPrice(driver);	
						 line = "130";
	                     driver.findElement(By.xpath("/html/body/div[1]/main/section/div/div/div/div[5]/div/div[4]/form/button")).click();
	                     successMessage(driver);
	                     afterBalance(driver);
						 error = 1;
						 break;
				}//switch
			}//try
	        catch(Exception e) {
				System.out.println("Element not found at line " +e);				
			}//catch
		}//do
		while(error == 0);		
		Method method = cls.getDeclaredMethod("Verify", arg[0],arg[1],arg[2],arg[3],arg[4],arg[5],arg[6],arg[7]);
		method.invoke(obj, gameName, deno, paymentChannel, productPriceWithoutCurrency, balanceBefore, balanceAfter, successMessage, testCase);
	}//WebshopProductDetailPage
	public static void beforeBalance(WebDriver driver) throws InterruptedException{
		Thread.sleep(20000);
		Thread.sleep(20000);
		balanceBefore = driver.findElement(By.xpath("/html/body/div[1]/nav/div/ul/li[4]/form/ul/li/ul/div/div[2]/div[1]/div[1]/span")).getText();
		System.out.println("Balance before is " +balanceBefore);
	}
	public static void productPrice(WebDriver driver){
		 productPrice = driver.findElement(By.xpath("/html/body/div[1]/main/section/div/div/div/div[2]/div[2]/div[4]/div/h4/span[2]/span")).getText();//get the actual price
         productPriceWithoutCurrency = productPrice.replaceAll("[^\\d.]", "");
		 System.out.println("Product price is =  " + productPriceWithoutCurrency);		
	}
	public static void afterBalance(WebDriver driver) throws InterruptedException{
		Thread.sleep(20000);
        driver.findElement(By.xpath("/html/body/div[1]/nav/div/ul/li[4]/form/ul/li/a/div/img")).click(); //click to view profile
		balanceAfter = driver.findElement(By.xpath("/html/body/div[1]/nav/div/ul/li[4]/form/ul/li/ul/div/div[2]/div[1]/div[1]/span")).getText();
		System.out.println("Balance after  is " + balanceAfter);
	}
	public static void successMessage(WebDriver driver) throws InterruptedException {
		Thread.sleep(20000);
		successMessage = driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div/div/div[2]/div[2]/div/div/div[11]/div[2]/span")).getText();
		
		if (successMessage.contains("Successful")) {
			System.out.println("Transaction successful!");
			System.out.println(successMessage);
	    } 
		else {
			System.out.println("Transaction failed!");
			System.out.println(successMessage);
		}
	}//	WebshopProductDetailsPage
}//Page_WebshopProductDetailsPage
	
