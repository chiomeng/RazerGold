import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
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


public class Page_WebshopProductDetailsPage_27Dec2021 {
	static int error;
	static String line;
	static String clickBox;
	static String balance_after;
	static String product_price;
	public static void ProductDetailsPage(WebDriver driver, String game_name, String userid, String serverid, String deno, String payment_channel, String save_details) throws InterruptedException {
		error = 0;
		do {
			try {
				//WebDriverWait wait = new WebDriverWait(driver, 120);
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				//Thread.sleep(7000);
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/nav/div/ul/a/span")));      //elementToBeClickable(By.xpath("/html/body/div[1]/nav/div/ul/a")));
				//Thread.sleep(7000);
				Before_Balance(driver); 
				driver.findElement(By.xpath("/html/body/div[1]/nav/div/ul/a/span")).click(); // click on Search button
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Search']")));
				//Thread.sleep(7000);
				driver.findElement(By.xpath("//*[@placeholder='Search']")).sendKeys(game_name); //enter product name
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div[2]/a")));
				//Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div[2]/a")).click(); //click on returned item due to search
				switch (game_name) { 
				   case "MU Origin 2":
					 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Game User ID")));
					 //Thread.sleep(5000);
					 driver.findElement(By.name("Game User ID")).sendKeys(userid); //Enter User ID	
					 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ServerId")));
					 //Thread.sleep(7000);
					 line = "MU 67";
					 driver.findElement(By.name("ServerId")).sendKeys(serverid); //EnterServerID
					 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'"+deno+"')]")));
					 //Thread.sleep(7000);
					 line = "MU 71";
					 driver.findElement(By.xpath("//*[contains(text(),'"+deno+"')]")).click(); // click deno
					 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(payment_channel)));
					 //Thread.sleep(7000);
					 line = "MU 75";
					 driver.findElement(By.xpath(payment_channel)).click(); //click payment channel
					 //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div[2]/div[2]/div/div[4]/div[3]/div/div[2]")));
					 //Thread.sleep(7000);
					 Product_Price(driver);
					 line = "MU 80";
					 driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div[2]/div[2]/div/div[4]/div[3]/div/div[2]")).click(); //click  to continue
					 //Moving to payweb					 
					 //WebElement I_Agree; 
					 //I_Agree = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[4]/a")));
					 //I_Agree.click();
					 //Thread.sleep(20000);
					 //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[4]/a")));
					 line = "MU 88";
					 //driver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/a")).click(); //click on I agree
					 Thread.sleep(20000);
					 clickBox = driver.findElement(By.xpath("//*[@id='dialogPanel1']/div[4]/a")).getText();
					 System.out.println(clickBox);
					 if(clickBox == "I AGREE"){
						 driver.findElement(By.xpath("//*[@id='dialogPanel1']/div[4]/a")).click();						 
					 }
					 else{
						 
					 }
					 //driver.findElement(By.xpath("//*[contains(text(),'I AGREE')]")).click();
					 //driver.findElement(By.cssSelector("a[class='btn btn-primary']")).click();
					 //driver.findElement(By.xpath("//a[contains(@class, 'button') and contains(@class, 'button-primary')]")).click(); 
					 line = "130";
                     driver.findElement(By.xpath("/html/body/div[1]/main/section/div/div/div/div[5]/div/div[4]/form/button")).click();
                     After_Balance(driver);
					 error = 1;
					 break;
				     case "Mobile Legends":
					 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Game User ID")));
					 //Thread.sleep(5000);
					 driver.findElement(By.name("Game User ID")).sendKeys(userid); //Enter User ID	
					 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ServerId")));
					 //Thread.sleep(7000);
					 line = "99";
					 driver.findElement(By.name("ServerId")).sendKeys(serverid); //EnterServerID
					 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'"+deno+"')]")));
					 //Thread.sleep(7000);
					 line = "103";
					 //driver.findElement(By.xpath("//button[text()='42 Diamonds']")).click(); // click deno
					 driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div/div/div[2]")).click();
					 //driver.findElement(By.xpath("div[contains(@area-labelledby,'14 Diamonds - RM 1.00')]")).click();
					 //driver.find_elements_by_xpath("//button[text()='button_text']").click();
					 //driver.findElement(By.xpath("div[contains(@area-labelledby,'"+deno+"')]")).click();
					 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(payment_channel)));
					 //Thread.sleep(7000);
					 line = "107";
					 driver.findElement(By.xpath(payment_channel)).click(); //click payment channel
					 //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div[2]/div[2]/div/div[4]/div[3]/div/div[2]")));
					 //Thread.sleep(7000);
					 Product_Price(driver);
					 line = "111";
					 driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div[2]/div[2]/div/div[4]/div[3]/div/div[2]")).click(); //click  to continue
					 //Moving to payweb					 
					 //WebElement I_Agree; 
					 //I_Agree = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[4]/a")));
					 //I_Agree.click();
					 //Thread.sleep(20000);
					 //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[4]/a")));
					 line = "123";
					 //driver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/a")).click(); //click on I agree
					 //driver.findElement(By.cssSelector("a.btn.btn-primary")).click();
					 Thread.sleep(20000);
					 clickBox = driver.findElement(By.xpath("//*[@id='dialogPanel1']/div[4]/a")).getText();
					 System.out.println(clickBox);
					 if(clickBox == "I AGREE"){
						 driver.findElement(By.xpath("//*[@id='dialogPanel1']/div[4]/a")).click();
					 }
					 else{
						 
					 }
					 //driver.findElement(By.xpath("//*[contains(text(),'I AGREE')]")).click();
					 //driver.findElement(By.cssSelector("a[class='btn btn-primary']")).click();
					 //driver.findElement(By.xpath("//a[contains(@class, 'button') and contains(@class, 'button-primary')]")).click(); 
					 line = "130";
                     driver.findElement(By.xpath("/html/body/div[1]/main/section/div/div/div/div[5]/div/div[4]/form/button")).click();
                     After_Balance(driver);
					 error = 1;
					 break;
				}//switch
			}//try
	        catch(Exception e) {
				System.out.println("Element not found at line " +line);				
			}//catch
		}//do
		while(error == 0);		
		//Thread.sleep(5000);
		//driver.findElement(By.xpath("//*[contains (text(), '14 Diamonds' ) ]]")).click();
	}//ProductDetailPage
	public static void Before_Balance(WebDriver driver) throws InterruptedException{
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]/nav/div/ul/li[3]/form/ul/li/a/div/img")).click(); //click to view profile
		Thread.sleep(20000);
		String balance = driver.findElement(By.xpath("/html/body/div[1]/nav/div/ul/li[3]/form/ul/li/ul/div/div[2]/div[1]/div[1]/span")).getText();
		System.out.println("Balance before is " +balance);
	}
	public static void Product_Price(WebDriver driver){
		 product_price = driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[4]/div[3]/div/div[1]/div[1]/span[2]/div/span")).getText();//get the actual price
         System.out.println("Product price is =  " + product_price);		
	}
	public static void After_Balance(WebDriver driver) throws InterruptedException{
		Thread.sleep(20000);
        driver.findElement(By.xpath("/html/body/div[1]/nav/div/ul/li[3]/form/ul/li/a/div/img")).click(); //click to view profile
		balance_after = driver.findElement(By.xpath("/html/body/div[1]/nav/div/ul/li[3]/form/ul/li/ul/div/div[2]/div[1]/div[1]/span")).getText();
		System.out.println("Balance after  is " +balance_after);
	}
}//Page_WebshopProductDetailsPage
	
