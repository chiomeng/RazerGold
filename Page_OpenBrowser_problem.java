import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.WebDriver;

// 
// Decompiled by Procyon v0.5.36
// 

public class Page_OpenBrowser_problem
{
    public WebDriver OpenBrowser(final String test_case, final String address) {
        final FirefoxProfile profile = new FirefoxProfile();
        if (test_case.contains("FF")) {
            System.out.println("RUnning Page_OpenBrowser");
            System.out.println("Now executing test with firefox browser");
            //final WebDriver driver = (WebDriver)new FirefoxDriver(profile);
            //driver.get(address);
            //return driver;
        }
        System.out.println("Now executing test with chrome browser");
        System.setProperty("webdriver.chrome.driver", "C:\\TA\\chromedriver.exe");
        final WebDriver driver = (WebDriver)new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(address);
        return driver;
    }
}