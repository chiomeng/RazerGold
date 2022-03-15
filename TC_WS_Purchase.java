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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;

public class TC_WS_Purchase {
	static String firefox = "Firefox";	
	static Page_OpenBrowser Page_OpenBrowser = new Page_OpenBrowser();
	//public static int count;	
	static String amt;
	static String pnt;
	static ArrayList<String> amtList = new ArrayList<String>();	
	static ArrayList<String> PointList = new ArrayList<String>();
	static int amount_col = 0;
	static int points_col = 0;
	static int count_row_amt_actual = 0; // amount of rows without header
	static int amt_ref = 0; //to be used as condition in the for loop
	static int amt_ref1;
	static int c;
	static int b;
	static int round = 0;
	//static String telco;
	static int test_cycle;
	static int count_row;
	static String method;
	static int count_tab_login;
	static int telco;
	static String testCase;
	static String address;
	static String testData;
	static String testDataTab1;
	static String testDataTab2;
	static String date_time;
	static String testResultFilename;
	static String username;
	static String password;
	static String browser;
    static String classname; 
    static String game_name;
    static String userid;
    static String serverid;
    static String deno;
    static String xpath;
    static String payment_channel;
    static String save_details;
    static String promo_code;
    static String tfa;
    static String code;
    static String cancel;
    static String ok;
    static int initial_row = 1;
    static String user_status;
    static String region; 
    static WebDriver driver;	
	@SuppressWarnings({ "resource", "static-access", "null" })
	public static void main(String[] args) throws Throwable {		
		// Comment this section when running in development mode
		/*testCase = args[0];		
		//String address = args[1];		
		String testData = args[1];				
		//String testData_tab = args[3];
	    String testResult = args[2];
	    String testCycle = args[3];
	    int testCycleInt = Integer.parseInt(testCycle);
	    String date_time = new SimpleDateFormat("yyyyMMdd_HHmm'.xlsx'").format(new Date());
		testResultFilename = testResult+testCase+"_"+date_time;
		String testDataTab1 = "Login";
		String testDataTab2 = "Webshop Purchase";		
		address = "https://www.zgold-qa.razer.com/"; */
		//int testCycleInt = 1;
		
		// The following section is commented when running in live mode
		testCase = "WS_Purchase"; //If firefox, append "FF"
		address = "https://www.zgold-qa.razer.com/";
		//address = "https://gold.razer.com";
		testData = "C:\\TA\\TD\\TD2.xlsx";				
		testDataTab1 = "Login";
		testDataTab2 = "Webshop Purchase";	    
		date_time = new SimpleDateFormat("yyyyMMdd_HHmm'.xlsx'").format(new Date());
		testResultFilename = "c://TA//TR//"+testCase+"_"+date_time;
		method = "VerifyPaymentchannel";	
		user_status = "Logged in";
		//String browser = new Exception().getStackTrace()[0].getClassName();     	       				
		// the following is For testing only, can be deleted for deployment
		/**System.out.println("testCase = " + testCase);
	    System.out.println("address = " + address);
	    System.out.println("test_data = " + test_data);
	    System.out.println("test_data_tab_1 = " + test_data_tab_1);
	    System.out.println("test_data_tab_2 = " + test_data_tab_2);
	    //System.out.println("test_result = " + test_result);		    
	    /*Read data from test data --> Login tab*/
		
		//for(int testCycleNumber = 1; testCycleNumber<=testCycleInt; testCycleNumber++) {
	    
	    /////////////////////////////////////////////////////////////////////////////
	    ///////   Login Section                                    /////////////////
	    /////////////////////////////////////////////////////////////////////////////
	    
	    FileInputStream Login = new FileInputStream(testData);		
	 	XSSFWorkbook wb_Login = new XSSFWorkbook(Login);
	 	XSSFSheet tab_Login = wb_Login.getSheet(testDataTab1);
	 	System.out.println("No. of rows : " + tab_Login.getLastRowNum());
		for(count_tab_login = 1;count_tab_login<=tab_Login.getLastRowNum();count_tab_login++){         			
			XSSFRow row_Login = tab_Login.getRow(count_tab_login); //count how many rows within Login tab
			System.out.println("No. of rows in : " + testDataTab1 + " = " + tab_Login.getLastRowNum());
            //testCase = row_Login.getCell(0).toString();           
            username = row_Login.getCell(0).toString();
            password = row_Login.getCell(1).toString();		
		    browser = new Exception().getStackTrace()[0].getClassName(); 
		    System.out.println("Browser = " + browser);
		    Class<?> cls = Class.forName(browser);
		    System.out.println("CLS = " + cls);
		    //Object obj = cls.newInstance();	
		    classname = cls.getName();
		    System.out.println("Class = " + classname);
		    //String method = "VerifyLogin";		    
		    //Read data from test data --> MobPay tab				 	
			//System.out.println("No. of rows : " + sheet_Mob.getLastRowNum());
			//The following calculate number of rows in telco coloumn	
			driver = Page_OpenBrowser.OpenBrowser(testCase, address);		
			Page_Login.comLogin(driver, username, password, browser, classname, testCase, address, count_tab_login, testResultFilename, 
		    method);					
			//////////////////////////////////////////////////////////////////////////////////////////////////////////
			////////     WS PurchaseSection                                                     /////////////////////
			/////////////////////////////////////////////////////////////////////////////////////////////////////////
			DataFormatter formatter = new DataFormatter(); // for displaying sting EXACTLY as per excel sheet
			FileInputStream Mob = new FileInputStream(testData);		
			XSSFWorkbook wb_Mob = new XSSFWorkbook(Mob);
			XSSFSheet sheet_Mob = wb_Mob.getSheet(testDataTab2);	
			System.out.println("No. of  rows in : " + testDataTab2 + " = " + sheet_Mob.getLastRowNum());	
			int b = 0; // to start the counter for cell
			for(telco = 1; telco<=sheet_Mob.getLastRowNum(); telco++ ){ //count no. of rows in the said tab
				int c = b++;
				int d = c+1;				
				XSSFRow row_amt = sheet_Mob.getRow(d); 
				game_name = row_amt.getCell(0).toString();
				System.out.println("Game name = " + game_name);
				userid = row_amt.getCell(1).toString();				
				System.out.println("User ID = " + userid);		
				serverid = row_amt.getCell(2).toString();
				System.out.println("Server ID = " + serverid);
				deno = row_amt.getCell(3).toString();
				System.out.println("Deno = " + deno);
				payment_channel = row_amt.getCell(4).toString();
				System.out.println("Paytment Channel = " + payment_channel);
				save_details = row_amt.getCell(5).toString();
				if(save_details == "N") {
					System.out.println("Save details = No" );
				} 
				else {
					System.out.println("Save details = Yes" );
				}
				promo_code = row_amt.getCell(6).toString();
				if(promo_code == "Null") {
					System.out.println("Promo code = No promo code" );
				} 
				else {
					System.out.println("Save details = " + promo_code );
				}		
				/*
				serverid = String.valueOf(row_amt.getCell(2)).replaceFirst("\\.0+$", "");
				System.out.println("Amount = " + amount);
				tfa = row_amt.getCell(3).toString();
				System.out.println("Tfa = " + tfa);
				Cell cell = row_amt.getCell(4);
				//Code = String.valueOf(row_amt.getCell(4));
				DataFormatter obj_default = new DataFormatter();
				FormulaEvaluator obj = new XSSFFormulaEvaluator((XSSFWorkbook) wb_Mob);
				obj.evaluate(cell);
				code = obj_default.formatCellValue(cell, obj);				
				System.out.println("Code = " + code);
				cancel = row_amt.getCell(5).toString();	
				System.out.println("cancel = " + cancel);
				ok = row_amt.getCell(6).toString();	
				System.out.println("ok = " + ok);
				*/
				Page_WebshopProductDetailsPage Page_WebshopProductDetailsPage = new Page_WebshopProductDetailsPage();
				//Page_Gold_ReloadNow.MainMenu_Gold(driver, username, password, browser, classname, testCase, address, testResultFilename, xpath, amount, Code, cancel, ok );
				Page_WebshopProductDetailsPage.WebshopProductDetailsPage(game_name, userid, serverid, deno, payment_channel, save_details, classname, testCase, driver);    
			}//for telco
		}//for count tab login
		driver.quit();
		//}//testCycleNUmber
	}//main	
	public void Verify(String gameName, String deno, String paymentChannel, String productPrice, String balanceBefore, String balanceAfter, String successMessage, String testCase)throws Throwable{
		Thread.sleep(5000); 
		final DecimalFormat df = new DecimalFormat("0.00");
		double productPriceDouble = Double.parseDouble(productPrice);
		double balanceBeforeDouble = Double.parseDouble(balanceBefore);
		double balanceAfterDouble = Double.parseDouble(balanceAfter);
		double balanceAfterDoubleExpected = balanceBeforeDouble - productPriceDouble;
		String balanceAfterDoubleTwoDecimalExpected = df.format(balanceAfterDoubleExpected);
		//String balanceAfterStringExpected = Double.toString(balanceAfterDoubleExpected);
		//String balanceAfterStringTwoDecimal = df.format(String balanceAfterDoubleTwoDecimalExpected);
		System.out.println("Expected balance after enforce two decimal" + balanceAfterDoubleTwoDecimalExpected);
		if((successMessage.contains("Successful"))&&(balanceAfterDoubleExpected == balanceAfterDouble)) {
			String result = "Pass";
			Testresult testresult = new Testresult();
			testresult.TR_result(testCase, gameName, productPrice, balanceBefore, balanceAfterDoubleTwoDecimalExpected, balanceAfter, result); 
		}			
		else {
			String result = "Fail";
			Testresult testresult = new Testresult();
			testresult.TR_result(testCase, gameName, productPrice, balanceBefore, balanceAfterDoubleTwoDecimalExpected, balanceAfter, result); 
		}
	}		
	class Testresult{		
		public void TR_result(String testCase, String gameName, String productPrice, String balanceBefore, String balanceAfterStringExpected, String balanceAfter, String result) throws IOException{
			File file = new File(testResultFilename);			
			if(file.exists()){
				addTestresult(testCase, gameName, productPrice, balanceBefore, balanceAfterStringExpected, balanceAfter, result);
			}
			else{
				createTestresult(testCase);
				addTestresult(testCase, gameName, productPrice, balanceBefore, balanceAfterStringExpected, balanceAfter, result);
			}
		}
		void createTestresult(String testCase) throws IOException{
			System.out.println("Creating test result file "+ testResultFilename +" .......");
			FileOutputStream fos = new FileOutputStream(testResultFilename);
			XSSFWorkbook workbook = new XSSFWorkbook();    
			System.out.println(workbook);
			XSSFSheet sheet1  = workbook.createSheet("Test result");
			CellStyle style = workbook.createCellStyle();    	
			XSSFFont bold = workbook.createFont();
			bold.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			style.setFont(bold);
			style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			style.setBorderRight(XSSFCellStyle.BORDER_THIN);
			style.setBorderTop(XSSFCellStyle.BORDER_THIN);        
			int a = 0;    	
			Row row = sheet1.createRow(a);
			Cell tcHeader = row.createCell(0);
			tcHeader.setCellValue("Test Case");
			tcHeader.setCellStyle(style);				
			sheet1.autoSizeColumn(0);
			Cell gameNameHeader = row.createCell(1);
			gameNameHeader.setCellValue("Game Name");
			gameNameHeader.setCellStyle(style);
			sheet1.autoSizeColumn(1);
			Cell productPriceHeader= row.createCell(2);        
			productPriceHeader.setCellValue("Price");       
			productPriceHeader.setCellStyle(style);
			sheet1.autoSizeColumn(2);			
			Cell balanceBeforeHeader= row.createCell(3);        
			balanceBeforeHeader.setCellValue("Wallet Balance (Before)");       
			balanceBeforeHeader.setCellStyle(style);
			sheet1.autoSizeColumn(3);                                        
			Cell balanceAfterStringExpectedHeader = row.createCell(4);
			balanceAfterStringExpectedHeader.setCellValue("Expected Balance");           
			balanceAfterStringExpectedHeader.setCellStyle(style);
			sheet1.autoSizeColumn(4);
			Cell balanceAfterHeader = row.createCell(5);
			balanceAfterHeader.setCellValue("Actual Balance");
			balanceAfterHeader.setCellStyle(style);
			sheet1.autoSizeColumn(5);
			Cell resultHeader = row.createCell(6);
			resultHeader.setCellValue("Result");
			resultHeader.setCellStyle(style);	
			sheet1.autoSizeColumn(6);
			workbook.write(fos);
			fos.close();
			workbook.close();					
		}
		void addTestresult(String testCase, String gameName, String productPrice, String balanceBefore, String balanceAfterStringExpected, String balanceAfter, String result) throws IOException{
			System.out.println("Expected balance = " + balanceAfterStringExpected);
			int row = initial_row++;
			if(result == "Pass"){
				FileInputStream inputPass = new FileInputStream(testResultFilename);
			    //FileInputStream inputPass = new FileInputStream(Start.tc_result_filepath);
			   	XSSFWorkbook wbPass = new XSSFWorkbook(inputPass);
			   	XSSFSheet sheet2 = wbPass.getSheet("Test result");
			   	CellStyle stylePass = wbPass.createCellStyle();  
			   	stylePass.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			   	stylePass.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			   	stylePass.setBorderRight(XSSFCellStyle.BORDER_THIN);
			   	stylePass.setBorderTop(XSSFCellStyle.BORDER_THIN);		    	
			   	//int row = initial_row++;
			   	Row rowPass = sheet2.createRow(row);		    	
			   	Cell tcPass = rowPass.createCell(0);
			   	tcPass.setCellValue(testCase);
			   	tcPass.setCellStyle(stylePass);
			   	sheet2.autoSizeColumn(0);		    	
			   	Cell gameNamePass = rowPass.createCell(1);
			   	gameNamePass.setCellValue(gameName); 
			   	gameNamePass.setCellStyle(stylePass);
			   	sheet2.autoSizeColumn(1);				   	
			 	Cell productPricePass = rowPass.createCell(2);
			   	productPricePass.setCellValue(productPrice); 
			   	productPricePass.setCellStyle(stylePass);
			   	sheet2.autoSizeColumn(2);				   	
			   	Cell balanceBeforePass = rowPass.createCell(3);
			   	balanceBeforePass.setCellValue(balanceBefore); 
			   	balanceBeforePass.setCellStyle(stylePass);
			   	sheet2.autoSizeColumn(3);		   	
			   	Cell balanceAfterStringExpected_pass = rowPass.createCell(4);
			   	balanceAfterStringExpected_pass.setCellValue(balanceAfterStringExpected); 
			   	balanceAfterStringExpected_pass.setCellStyle(stylePass);
			   	sheet2.autoSizeColumn(4);			   	
			   	Cell balanceAfterActualPass = rowPass.createCell(5);
			   	balanceAfterActualPass.setCellValue(balanceAfter); 
			   	balanceAfterActualPass.setCellStyle(stylePass);
			   	sheet2.autoSizeColumn(5);		   	
			   	Cell resultPass = rowPass.createCell(6);
			   	resultPass.setCellValue("PASS"); 
			   	resultPass.setCellStyle(stylePass);
			   	sheet2.autoSizeColumn(6);			   	
			   	//FileOutputStream writePass = new FileOutputStream(Start.tc_result_filepath); 
			   	FileOutputStream writePass = new FileOutputStream(testResultFilename);
			   	wbPass.write(writePass);
			   	writePass.close();
			   	wbPass.close();
			}
			else{
				FileInputStream inputFail = new FileInputStream(testResultFilename);
				//FileInputStream inputPass = new FileInputStream(Start.tc_result_filepath);
			   	XSSFWorkbook wbFail = new XSSFWorkbook(inputFail);
			   	XSSFFont font = wbFail.createFont();
			   	XSSFSheet sheet2 = wbFail.getSheet("Test result");
			   	CellStyle styleFail = wbFail.createCellStyle();  
			   	styleFail.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			   	styleFail.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			   	styleFail.setBorderRight(XSSFCellStyle.BORDER_THIN);
			   	styleFail.setBorderTop(XSSFCellStyle.BORDER_THIN);				   	
			   	//int row = initial_row++;
			   	Row rowFail = sheet2.createRow(row);		    	
			   	Cell tcFail = rowFail.createCell(0);
			   	tcFail.setCellValue(testCase);
			   	tcFail.setCellStyle(styleFail);
			   	sheet2.autoSizeColumn(0);	
			   	font.setColor(IndexedColors.RED.getIndex());
	        	styleFail.setFont(font);  
			   	Cell gameNameFail = rowFail.createCell(1); 
			   	gameNameFail.setCellValue(gameName); 
			   	gameNameFail.setCellStyle(styleFail);
			   	sheet2.autoSizeColumn(1);	
			   	Cell productPriceFail = rowFail.createCell(2); 
			   	productPriceFail.setCellValue(productPrice); 
			   	productPriceFail.setCellStyle(styleFail);
			   	sheet2.autoSizeColumn(2);				   	
			   	Cell balanceBefore_fail = rowFail.createCell(3);
			   	balanceBefore_fail.setCellValue(balanceBefore); 
			   	balanceBefore_fail.setCellStyle(styleFail);
			   	sheet2.autoSizeColumn(3);	    	
			   	Cell balanceAfterStringExpected_fail = rowFail.createCell(4);
			   	balanceAfterStringExpected_fail.setCellValue(balanceAfterStringExpected); 
			   	balanceAfterStringExpected_fail.setCellStyle(styleFail);
			   	sheet2.autoSizeColumn(4);		    	
			   	Cell actual_productPrice_fail = rowFail.createCell(5);
			   	actual_productPrice_fail.setCellValue(balanceAfter); 
			   	actual_productPrice_fail.setCellStyle(styleFail);
			   	sheet2.autoSizeColumn(5);			    	
			   	Cell result_fail = rowFail.createCell(6);
			   	result_fail.setCellValue("FAIL"); 
			   	result_fail.setCellStyle(styleFail);
			   	sheet2.autoSizeColumn(6);			    	
			   	//FileOutputStream writePass = new FileOutputStream(Start.tc_result_filepath); 
			   	FileOutputStream writePass = new FileOutputStream(testResultFilename);
			   	wbFail.write(writePass);
			   	writePass.close();
			   	wbFail.close();				
			}
		}
	}
}
		    	
		    
