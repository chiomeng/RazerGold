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

//import TC_WS_Purchase.Testresult;

import java.util.ArrayList;

public class TC_GoldReload_WorldPay {
	static String firefox = "Firefox";	
	static Page_OpenBrowser Page_OpenBrowser = new Page_OpenBrowser();
	//public static int count;	
	static String amt;
	static String pnt;
	static ArrayList<String> amtList = new ArrayList<String>();	
	static ArrayList<String> PointList = new ArrayList<String>();
	static int amount_col = 0;
	static int points_col = 0;
	static int count_rowAmt_actual = 0; // amount of rows without header
	static int amt_ref = 0; //to be used as condition in the for loop
	static int amt_ref1;
	static int c;
	static int b;
	static int round = 0;
	//static String channels;
	static int test_cycle;
	static int count_row;
	static String method;
	static int count_tab_login;
	static int channels;
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
    static String className; 
    static String paymentChannel;
    static String channelLocator;
    static String reloadAmount;
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
    static String cardNumber;
    static WebDriver driver;
    
	
	@SuppressWarnings({ "resource", "static-access" })
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
		String testDataTab2 = "Reload WorldPay";		
		address = "https://www.zgold-qa.razer.com/"; 
		//System.out.println("Test case = " + testCase);
		//System.out.println("Test data = " + testData);*/
		
		// The following section is commented when running in live mode
		testCase = "GoldReload_WorldPay"; //If firefox, append "FF"
		address = "https://www.zgold-qa.razer.com/";
		//address = "https://gold.razer.com";
		testData = "C:\\TA\\TD\\TD2.xlsx";				
		testDataTab1 = "Login";
		testDataTab2 = "Reload WorldPay";	    
		date_time = new SimpleDateFormat("yyyyMMdd_HHmm'.xlsx'").format(new Date());
		testResultFilename = "c://TA//TR//"+testCase+"_"+date_time;
		method = "VerifyPaymentchannel";	
		user_status = "Logged in";
		//int testCycleInt = 1;
		
		//String browser = new Exception().getStackTrace()[0].getclassName();     	       				
		// the following is For testing only, can be deleted for deployment
		/*System.out.println("testCase = " + testCase);
	    System.out.println("address = " + address);
	    System.out.println("testData = " + testData);
	    System.out.println("testDataTab1 = " + testDataTab1);
	    System.out.println("testDataTab2 = " + testDataTab2);
	    //System.out.println("testResult = " + testResult);		    
	    Read data from test data --> Login tab*/
		//for(int testCycleNumber = 1; testCycleNumber<=testCycleInt; testCycleNumber++) { // use this when running in live
		for(int testCycleNumber = 1; testCycleNumber<=1; testCycleNumber++) { //use thihs during development 
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
		    //Object obj = cls.newInstance();	
		    className = cls.getName();
		    System.out.println("Class = " + className);
		    //String method = "VerifyLogin";		    
		    //Read data from test data --> reloadPay tab				 	
			//System.out.println("No. of rows : " + sheetReload.getLastRowNum());
			//The following calculate number of rows in channels coloumn	
			driver = Page_OpenBrowser.OpenBrowser(testCase, address);		
			Page_Login.comLogin(driver, username, password, browser, className, testCase, address, count_tab_login, testResultFilename, method); 
		   	//////////////////////////////////////////////////////////////////////////////////////////////////////////
			////////                   reload section                                            /////////////////////
			/////////////////////////////////////////////////////////////////////////////////////////////////////////
			DataFormatter formatter = new DataFormatter(); // for displaying sting EXACTLY as per excel sheet
			FileInputStream reload = new FileInputStream(testData);		
			XSSFWorkbook wbReload = new XSSFWorkbook(reload);
			XSSFSheet sheetReload = wbReload.getSheet(testDataTab2);	
			System.out.println("No. of  rows in : " + testDataTab2 + " = " + sheetReload.getLastRowNum());	
			int b = 0; // to start the counter for cell
			for(channels = 1; channels<=sheetReload.getLastRowNum(); channels++ ){ //count no. of rows in the said tab
				int c = b++;
				int d = c+1;				
				XSSFRow rowAmt = sheetReload.getRow(d); 
				paymentChannel = rowAmt.getCell(0).toString();
				System.out.println("Payment Channel = " + paymentChannel);
				channelLocator = rowAmt.getCell(1).toString();				
				System.out.println("Locator = " + channelLocator);		
				reloadAmount = rowAmt.getCell(2).toString();
				System.out.println("Amount = " + reloadAmount);				
				Page_Reload Page_Reload = new Page_Reload();				
				Page_Reload.reload(paymentChannel, channelLocator, reloadAmount, className, driver);   
			} //channels
		}// count tab login
		System.out.println("Execution of test case " + testCase + "is completed.");
		driver.quit();
		} //testCycleNumber
	}// main
	public void Verify(String paymentChannel, String reloadAmount, String currentGoldBalance, String newGoldBalance, String transStatus, String transNumber, String errorMessage)throws Throwable{
		Thread.sleep(5000); 
		final DecimalFormat df = new DecimalFormat("0.00");
		double reloadAmountDouble = Double.parseDouble(reloadAmount);
		double currentGoldBalanceDouble = Double.parseDouble(currentGoldBalance);
		double newGoldBalanceDouble = Double.parseDouble(newGoldBalance);
		double newGoldBalanceDoubleExpected = currentGoldBalanceDouble + reloadAmountDouble;
		String newGoldBalanceDoubleTwoDecimalExpected = df.format(newGoldBalanceDoubleExpected);
		//String newGoldBalanceStringExpected = Double.toString(newGoldBalanceDoubleExpected);
		//String newGoldBalanceStringTwoDecimal = df.format(String newGoldBalanceDoubleTwoDecimalExpected);
		System.out.println("Expected balance after enforce two decimal" + newGoldBalanceDoubleTwoDecimalExpected);
		if((transStatus.contains("Successful"))&&(newGoldBalanceDoubleExpected == newGoldBalanceDouble)) {
			String result = "Pass";
			Testresult testresult = new Testresult();
			testresult.TR_result(testCase, paymentChannel, reloadAmount, currentGoldBalance, newGoldBalanceDoubleTwoDecimalExpected, newGoldBalance, transNumber, result, errorMessage); 
		}		
		else {
			String result = "Fail";
			Testresult testresult = new Testresult();
			testresult.TR_result(testCase, paymentChannel, reloadAmount, currentGoldBalance, newGoldBalanceDoubleTwoDecimalExpected, newGoldBalance, transNumber, result, errorMessage);  
		}
	}		
	class Testresult{		
		public void TR_result(String testCase, String paymentChannel, String reloadAmount, String currentGoldBalance, String newGoldBalanceStringExpected, String newGoldBalance, String transNumber, String result, String errorMessage) throws IOException{
			File file = new File(testResultFilename);			
			if(file.exists()){
				addTestresult(testCase, paymentChannel, reloadAmount, currentGoldBalance, newGoldBalanceStringExpected, newGoldBalance, transNumber, result, errorMessage);
			}
			else{
				createTestresult(testCase);
				addTestresult(testCase, paymentChannel, reloadAmount, currentGoldBalance, newGoldBalanceStringExpected, newGoldBalance, transNumber, result, errorMessage);
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
			Cell paymentChannelHeader = row.createCell(1);
			paymentChannelHeader.setCellValue("Payment Channel");
			paymentChannelHeader.setCellStyle(style);
			sheet1.autoSizeColumn(1);
			Cell reloadAmountHeader= row.createCell(2);        
			reloadAmountHeader.setCellValue("Reload Amount");       
			reloadAmountHeader.setCellStyle(style);
			sheet1.autoSizeColumn(2);			
			Cell currentGoldBalanceHeader= row.createCell(3);        
			currentGoldBalanceHeader.setCellValue("Wallet Balance (Before)");       
			currentGoldBalanceHeader.setCellStyle(style);
			sheet1.autoSizeColumn(3);                                        
			Cell newGoldBalanceStringExpectedHeader = row.createCell(4);
			newGoldBalanceStringExpectedHeader.setCellValue("Expected Balance");           
			newGoldBalanceStringExpectedHeader.setCellStyle(style);
			sheet1.autoSizeColumn(4);
			Cell newGoldBalanceHeader = row.createCell(5);
			newGoldBalanceHeader.setCellValue("Actual Balance");
			newGoldBalanceHeader.setCellStyle(style);
			sheet1.autoSizeColumn(5);
			Cell resultHeader = row.createCell(6);
			resultHeader.setCellValue("Result");
			resultHeader.setCellStyle(style);	
			sheet1.autoSizeColumn(6);
			Cell transNumberHeader = row.createCell(7);
			transNumberHeader.setCellValue("Transaction Number");
			transNumberHeader.setCellStyle(style);	
			sheet1.autoSizeColumn(7);
			Cell errorMessageHeader = row.createCell(8);
			errorMessageHeader.setCellValue("Error Message");
			errorMessageHeader.setCellStyle(style);	
			sheet1.autoSizeColumn(7);
			workbook.write(fos);
			fos.close();
			workbook.close();					
		}
		void addTestresult(String testCase, String paymentChannel, String reloadAmount, String currentGoldBalance, String newGoldBalanceStringExpected, String newGoldBalance, String transNumber, String result, String errorMessage) throws IOException{
			System.out.println("Expected balance = " + newGoldBalanceStringExpected);
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
			   	Cell paymentChannelPass = rowPass.createCell(1);
			   	paymentChannelPass.setCellValue(paymentChannel); 
			   	paymentChannelPass.setCellStyle(stylePass);
			   	sheet2.autoSizeColumn(1);				   	
			 	Cell reloadAmountPass = rowPass.createCell(2);
			   	reloadAmountPass.setCellValue(reloadAmount); 
			   	reloadAmountPass.setCellStyle(stylePass);
			   	sheet2.autoSizeColumn(2);				   	
			   	Cell currentGoldBalancePass = rowPass.createCell(3);
			   	currentGoldBalancePass.setCellValue(currentGoldBalance); 
			   	currentGoldBalancePass.setCellStyle(stylePass);
			   	sheet2.autoSizeColumn(3);		   	
			   	Cell newGoldBalanceStringExpected_pass = rowPass.createCell(4);
			   	newGoldBalanceStringExpected_pass.setCellValue(newGoldBalanceStringExpected); 
			   	newGoldBalanceStringExpected_pass.setCellStyle(stylePass);
			   	sheet2.autoSizeColumn(4);			   	
			   	Cell newGoldBalanceActualPass = rowPass.createCell(5);
			   	newGoldBalanceActualPass.setCellValue(newGoldBalance); 
			   	newGoldBalanceActualPass.setCellStyle(stylePass);
			   	sheet2.autoSizeColumn(5);		   	
			   	Cell resultPass = rowPass.createCell(6);
			   	resultPass.setCellValue("PASS"); 
			   	resultPass.setCellStyle(stylePass);
			   	sheet2.autoSizeColumn(6);	
			   	Cell transNumberPass = rowPass.createCell(7);
			   	transNumberPass.setCellValue(transNumber); 
			   	transNumberPass.setCellStyle(stylePass);
			   	sheet2.autoSizeColumn(7);	
			   	Cell errorMessagePass = rowPass.createCell(8);
			   	errorMessagePass.setCellValue(errorMessage); 
			   	errorMessagePass.setCellStyle(stylePass);
			   	sheet2.autoSizeColumn(8);
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
			   	Cell paymentChannelFail = rowFail.createCell(1); 
			   	paymentChannelFail.setCellValue(paymentChannel); 
			   	paymentChannelFail.setCellStyle(styleFail);
			   	sheet2.autoSizeColumn(1);	
			   	Cell reloadAmountFail = rowFail.createCell(2); 
			   	reloadAmountFail.setCellValue(reloadAmount); 
			   	reloadAmountFail.setCellStyle(styleFail);
			   	sheet2.autoSizeColumn(2);				   	
			   	Cell currentGoldBalance_fail = rowFail.createCell(3);
			   	currentGoldBalance_fail.setCellValue(currentGoldBalance); 
			   	currentGoldBalance_fail.setCellStyle(styleFail);
			   	sheet2.autoSizeColumn(3);	    	
			   	Cell newGoldBalanceStringExpected_fail = rowFail.createCell(4);
			   	newGoldBalanceStringExpected_fail.setCellValue(newGoldBalanceStringExpected); 
			   	newGoldBalanceStringExpected_fail.setCellStyle(styleFail);
			   	sheet2.autoSizeColumn(4);		    	
			   	Cell actual_reloadAmount_fail = rowFail.createCell(5);
			   	actual_reloadAmount_fail.setCellValue(newGoldBalance); 
			   	actual_reloadAmount_fail.setCellStyle(styleFail);
			   	sheet2.autoSizeColumn(5);			    	
			   	Cell result_fail = rowFail.createCell(6);
			   	result_fail.setCellValue("FAIL"); 
			   	result_fail.setCellStyle(styleFail);
			   	sheet2.autoSizeColumn(6);		
			   	Cell transNumberFail = rowFail.createCell(7);
			   	transNumberFail.setCellValue(transNumber); 
			   	transNumberFail.setCellStyle(styleFail);
			   	sheet2.autoSizeColumn(7);	
			   	Cell errorMessageFail = rowFail.createCell(8);
			   	errorMessageFail.setCellValue(errorMessage); 
			   	errorMessageFail.setCellStyle(styleFail);
			   	sheet2.autoSizeColumn(8);
			   	//FileOutputStream writePass = new FileOutputStream(Start.tc_result_filepath); 
			   	FileOutputStream writePass = new FileOutputStream(testResultFilename);
			   	wbFail.write(writePass);
			   	writePass.close();
			   	wbFail.close();				
			}
		}
	}
}	