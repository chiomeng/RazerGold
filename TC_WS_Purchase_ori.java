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

public class TC_WS_Purchase_ori {
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
	static String test_case;
	static String address;
	static String test_data;
	static String test_data_tab_1;
	static String test_data_tab_2;
	static String date_time;
	static String test_result_filename;
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
	
	@SuppressWarnings({ "resource", "static-access" })
	public static void main(String[] args) throws Throwable {
		
		// Comment this section when running in development mode
		
		/*
		String test_case = args[0];		
		String address = args[1];		
		String test_data = args[2];				
		//String test_data_tab = args[3];
	    String test_result = args[3];	
	    String date_time = new SimpleDateFormat("yyyyMMdd_HHmm'.xlsx'").format(new Date());
		String test_result_filename = test_result+test_case+"_"+date_time;
		String test_data_tab_1 = "Common_Login";
		String test_data_tab_2 = "MobPay";	
		*/   	
		
		// Comment bove section when running in development mode
		
		// The following section is commented when running in live mode
		test_case = "WS_Purchase"; //If firefox, append "FF"
		address = "https://www.zgold-qa.razer.com/";
		//address = "https://gold.razer.com";
		test_data = "C:\\TA\\TD\\TD.xlsx";				
		test_data_tab_1 = "Login";
		test_data_tab_2 = "Webshop Purchase";	    
		date_time = new SimpleDateFormat("yyyyMMdd_HHmm'.xlsx'").format(new Date());
		test_result_filename = "c://TA//TR//"+test_case+"_"+date_time;
		method = "VerifyPaymentchannel";	
		user_status = "Logged in";
		//String browser = new Exception().getStackTrace()[0].getClassName();     	       				
		// the following is For testing only, can be deleted for deployment
		/**System.out.println("test_case = " + test_case);
	    System.out.println("address = " + address);
	    System.out.println("test_data = " + test_data);
	    System.out.println("test_data_tab_1 = " + test_data_tab_1);
	    System.out.println("test_data_tab_2 = " + test_data_tab_2);
	    //System.out.println("test_result = " + test_result);		    
	    /*Read data from test data --> Login tab*/
	    
	    /////////////////////////////////////////////////////////////////////////////
	    ///////   Login Section                                    /////////////////
	    /////////////////////////////////////////////////////////////////////////////
	    
	    FileInputStream Login = new FileInputStream(test_data);		
	 	XSSFWorkbook wb_Login = new XSSFWorkbook(Login);
	 	XSSFSheet tab_Login = wb_Login.getSheet(test_data_tab_1);
	 	System.out.println("No. of rows : " + tab_Login.getLastRowNum());
		for(count_tab_login = 1;count_tab_login<=tab_Login.getLastRowNum();count_tab_login++){         			
			XSSFRow row_Login = tab_Login.getRow(count_tab_login); //count how many rows within Login tab
			System.out.println("No. of rows in : " + test_data_tab_1 + " = " + tab_Login.getLastRowNum());
            //test_case = row_Login.getCell(0).toString();           
            username = row_Login.getCell(0).toString();
            password = row_Login.getCell(1).toString();		
		    browser = new Exception().getStackTrace()[0].getClassName(); 
		    System.out.println("Browser = " + browser);
		    Class<?> cls = Class.forName(browser);
		    //Object obj = cls.newInstance();	
		    classname = cls.getName();
		    //String method = "VerifyLogin";		    
		    //Read data from test data --> MobPay tab				 	
			//System.out.println("No. of rows : " + sheet_Mob.getLastRowNum());
			//The following calculate number of rows in telco coloumn	
			WebDriver driver = Page_OpenBrowser.OpenBrowser(test_case, address);		
			Page_Login.comLogin(driver, username, password, browser, classname, test_case, address, count_tab_login, test_result_filename, 
		    method);					
			//////////////////////////////////////////////////////////////////////////////////////////////////////////
			////////     WS PurchaseSection                                                     /////////////////////
			/////////////////////////////////////////////////////////////////////////////////////////////////////////
			DataFormatter formatter = new DataFormatter(); // for displaying sting EXACTLY as per excel sheet
			FileInputStream Mob = new FileInputStream(test_data);		
			XSSFWorkbook wb_Mob = new XSSFWorkbook(Mob);
			XSSFSheet sheet_Mob = wb_Mob.getSheet(test_data_tab_2);	
			System.out.println("No. of  rows in : " + test_data_tab_2 + " = " + sheet_Mob.getLastRowNum());	
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
				Page_WebshopProductDetailsPage_ori Page_ProductDetailsPage = new Page_WebshopProductDetailsPage_ori();
				//Page_Gold_ReloadNow.MainMenu_Gold(driver, username, password, browser, classname, test_case, address, test_result_filename, xpath, amount, Code, cancel, ok );
				Page_ProductDetailsPage.ProductDetailsPage(driver, game_name, userid, serverid, deno, payment_channel, save_details);    
			}
		}
	}	
	public void VerifyPaymentchannel(WebDriver driver, String browser, String xpath, String amount, String tfa, String code, String cancel, String ok, String points_before, String reload_pending, String points_after)
	throws Throwable{
		Thread.sleep(5000); 
		String expected_reload_pending = "RELOAD PENDING";
		String testcase = test_case + "_" ; 
		if((points_before == points_after)&&(reload_pending == expected_reload_pending)){
			String result = "Pass";
			Testresult testresult = new Testresult();
			testresult.TR_result(testcase, points_before, reload_pending, points_after, expected_reload_pending, result);
		}
		else {//((!points_before.equals(points_after))||(!reload_pending.equals(expected_reload_pending))){
			String result = "Fail";
			Testresult testresult = new Testresult();
			testresult.TR_result(testcase, points_before, reload_pending, points_after, expected_reload_pending, result);
		}
	}	
	public class Testresult{		
		public void TR_result(String testcase, String points_before, String reload_pending, String points_after, String expected_reload_pending, String result) throws IOException{
			File file = new File(test_result_filename);			
			if(file.exists()){
				addTestresult(testcase, points_before, reload_pending, points_after, expected_reload_pending, result);
			}
			else{
				createTestresult(testcase);
				addTestresult(testcase, points_before, reload_pending, points_after, expected_reload_pending, result);
			}
		}
		void createTestresult(String testcase) throws IOException{
			System.out.println("Creating test result file "+ test_result_filename +" .......");
			FileOutputStream fos = new FileOutputStream(test_result_filename);
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
			Cell tc_header = row.createCell(0);
			tc_header.setCellValue("Test Case");
			tc_header.setCellStyle(style);				
			sheet1.autoSizeColumn(0);
			Cell points_before_header = row.createCell(1);
			points_before_header.setCellValue("Points Before");
			points_before_header.setCellStyle(style);
			sheet1.autoSizeColumn(1);
			Cell points_after_header= row.createCell(2);        
			points_after_header.setCellValue("Points After");       
			points_after_header.setCellStyle(style);
			sheet1.autoSizeColumn(2);
			Cell expected_message_header = row.createCell(3);
			expected_message_header.setCellValue("Expected Message");           
			expected_message_header.setCellStyle(style);
			sheet1.autoSizeColumn(3);
			Cell actual_message_header = row.createCell(4);
			actual_message_header.setCellValue("Actual Message");
			actual_message_header.setCellStyle(style);
			Cell result_header = row.createCell(5);
			result_header.setCellValue("result");
			result_header.setCellStyle(style);				
			workbook.write(fos);
			fos.close();
			workbook.close();					
		}
		void addTestresult(String testcase, String points_before, String reload_pending, String points_after, String expected_reload_pending, String result) throws IOException{
			int row = initial_row++;
			if(result == "Pass"){
				FileInputStream input_pass = new FileInputStream(test_result_filename);
			    //FileInputStream input_pass = new FileInputStream(Start.tc_result_filepath);
			   	XSSFWorkbook wb_pass = new XSSFWorkbook(input_pass);
			   	XSSFSheet sheet2 = wb_pass.getSheet("Test result");
			   	CellStyle style_pass = wb_pass.createCellStyle();  
			   	style_pass.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			   	style_pass.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			   	style_pass.setBorderRight(XSSFCellStyle.BORDER_THIN);
			   	style_pass.setBorderTop(XSSFCellStyle.BORDER_THIN);		    	
			   	//int row = initial_row++;
			   	Row row_pass = sheet2.createRow(row);		    	
			   	Cell tc_pass = row_pass.createCell(0);
			   	tc_pass.setCellValue(test_case);
			   	tc_pass.setCellStyle(style_pass);
			   	sheet2.autoSizeColumn(0);		    	
			   	Cell points_before_pass = row_pass.createCell(1);
			   	points_before_pass.setCellValue(points_before); 
			   	points_before_pass.setCellStyle(style_pass);
			   	sheet2.autoSizeColumn(1);		    	
			   	Cell points_after_Pass = row_pass.createCell(2);
			   	points_after_Pass.setCellValue(points_after); 
			   	points_after_Pass.setCellStyle(style_pass);
			   	sheet2.autoSizeColumn(2);	
			   	
			   	
			   	Cell expected_reload_pending_pass = row_pass.createCell(3);
			   	expected_reload_pending_pass.setCellValue(expected_reload_pending); 
			   	expected_reload_pending_pass.setCellStyle(style_pass);
			   	sheet2.autoSizeColumn(3);		
			   	
			   	
			   	
			   	Cell actual_reload_pending_pass = row_pass.createCell(4);
			   	expected_reload_pending_pass.setCellValue(expected_reload_pending); 
			   	expected_reload_pending_pass.setCellStyle(style_pass);
			   	sheet2.autoSizeColumn(4);	
			   	
			   	
			   	
			   	Cell result_pass = row_pass.createCell(5);
			   	expected_reload_pending_pass.setCellValue("PASS"); 
			   	expected_reload_pending_pass.setCellStyle(style_pass);
			   	sheet2.autoSizeColumn(5);	
			   	
			   
			   	
			   	
			   	
			   	
			   	//FileOutputStream write_pass = new FileOutputStream(Start.tc_result_filepath); 
			   	FileOutputStream write_pass = new FileOutputStream(test_result_filename);
			   	wb_pass.write(write_pass);
			   	write_pass.close();
			   	wb_pass.close();
			}
			else{
				FileInputStream input_fail = new FileInputStream(test_result_filename);
				//FileInputStream input_pass = new FileInputStream(Start.tc_result_filepath);
			   	XSSFWorkbook wb_fail = new XSSFWorkbook(input_fail);
			   	XSSFFont font = wb_fail.createFont();
			   	XSSFSheet sheet2 = wb_fail.getSheet("Test result");
			   	CellStyle style_fail = wb_fail.createCellStyle();  
			   	style_fail.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			   	style_fail.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			   	style_fail.setBorderRight(XSSFCellStyle.BORDER_THIN);
			   	style_fail.setBorderTop(XSSFCellStyle.BORDER_THIN);				   	
			   	//int row = initial_row++;
			   	Row row_fail = sheet2.createRow(row);		    	
			   	Cell tc_fail = row_fail.createCell(0);
			   	tc_fail.setCellValue(test_case);
			   	tc_fail.setCellStyle(style_fail);
			   	sheet2.autoSizeColumn(0);	
			   	font.setColor(IndexedColors.RED.getIndex());
	        	style_fail.setFont(font);  
			   	Cell points_before_fail = row_fail.createCell(1); 
			   	points_before_fail.setCellValue(points_before); 
			   	points_before_fail.setCellStyle(style_fail);
			   	sheet2.autoSizeColumn(1);		    	
			   	Cell points_after_fail = row_fail.createCell(2);
			   	points_after_fail.setCellValue(points_after); 
			   	points_after_fail.setCellStyle(style_fail);
			   	sheet2.autoSizeColumn(2);	    	
			   	Cell expected_reload_pending_fail = row_fail.createCell(3);
			   	expected_reload_pending_fail.setCellValue(expected_reload_pending); 
			   	expected_reload_pending_fail.setCellStyle(style_fail);
			   	sheet2.autoSizeColumn(3);		    	
			   	Cell actual_reload_pending_fail = row_fail.createCell(4);
			   	actual_reload_pending_fail.setCellValue(expected_reload_pending); 
			   	actual_reload_pending_fail.setCellStyle(style_fail);
			   	sheet2.autoSizeColumn(4);			    	
			   	Cell result_fail = row_fail.createCell(5);
			   	result_fail.setCellValue("FAIL"); 
			   	result_fail.setCellStyle(style_fail);
			   	sheet2.autoSizeColumn(5);			    	
			   	//FileOutputStream write_pass = new FileOutputStream(Start.tc_result_filepath); 
			   	FileOutputStream write_pass = new FileOutputStream(test_result_filename);
			   	wb_fail.write(write_pass);
			   	write_pass.close();
			   	wb_fail.close();				
			}
		}
	}
}
		    	
		    
