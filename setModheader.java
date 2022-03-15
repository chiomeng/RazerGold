import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class setModheader {
	public static void main(String[] args){
		System.out.println("Now executing test with chrome browser");
	    System.setProperty("webdriver.chrome.driver", "C:\\TA\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    ChromeOptions options = new ChromeOptions();	    
	    options.addExtensions(new File("C:\\TA\\chrome-modheader\\modheader.crx"));
	    driver.manage().window().maximize();
	    driver.get("chrome-extension://idgpnmonknjnojddfkpgkljpfnnfcklj/icon.png");
	    ((JavascriptExecutor)driver).executeScript(
			    "localStorage.setItem('profiles', JSON.stringify([{" +
			            "  title: 'Selenium', hideComment: true, appendMode: ''," +
			            "  headers: [" +
			            "    {enabled: true, name: 'true-client-ip', value: '1.9.46.250', comment: ''}, " +
			            "    {enabled: true, name: 'X-client-IP', value: '1.9.45.250', comment: ''} " +
			            "  ]," +
			            "  respHeaders: []," +
			            "  filters: []" +
			            "}]));");
	    driver.get("https://www.zgold-qa.razer.com/");
	}
}
