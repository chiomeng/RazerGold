import java.lang.reflect.InvocationTargetException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// 
// Decompiled by Procyon v0.5.36
// 

public class Page_Login {
    public static void comLogin(final WebDriver driver, final String username, final String password, final String browser, final String classname, final String test_case, final String address, final int count, final String test_result_filename, final String method) throws InterruptedException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        final String tc = test_case;
        final String un = username;
        final String pw = password;
        final String brw = browser;
        final String cn = classname;
        final String add = address;
        final String result = test_result_filename;
        final String method_caller = method;
        final int count_row = count;
        final Class[] arg = { WebDriver.class, String.class, Integer.TYPE, String.class, String.class, String.class };
        final Class<?> cls = Class.forName(browser);
        final Object obj = cls.newInstance();
        if (classname.contains("FF")) {
            System.out.println("RUnning Page_Login");
            Thread.sleep(5000);
            //driver.findElement(By.xpath("//*[@id='popupfoot']/a/i")).click();
            driver.findElement(By.xpath("//*[@id='CountryForm']/ul/li[1]/a")).click();
            //Thread.sleep(10000L);
            driver.findElement(By.xpath("//*[@id='EmailAddress']")).sendKeys(new CharSequence[] { un });
            driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(new CharSequence[] { pw });
            driver.findElement(By.xpath("//*[@id='LoginForm']/footer[1]/table/tbody/tr/td[2]/button")).click();
        }
        else {
        	Thread.sleep(7000);
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div[2]/a")).click(); //click on I AGREE in policy update dialog box
            Thread.sleep(7000);
            driver.findElement(By.xpath("/html/body/div[1]/nav/div/ul/li[3]/form/a")).click(); //click on Log IN
            //driver.findElement(By.xpath("//*[@id='main']/body/div[1]/nav/div/ul/li[3]/form/a")).click();
            //driver.findElement(By.cssSelector(".text--black.rzr-icon-cross.standalone-icon-24.cta--no-underline")).click();
            //driver.findElement(By.className("rzr-icon-cross")).click();
            //driver.findElement(By.xpath("//div[@class='text--black rzr-icon-cross standalone-icon-24 cta--no-underline']")).click();
            //xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[2]/div/a")).click();
            //driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div/button[1]")).click();
            //driver.findElement(By.xpath("/html/body/div[1]/nav/div/ul/li[3]/form/ul/li/a/div/div[1]/span")).click();
            //driver.findElement(By.xpath("/html/body/div[1]/nav/div/ul/li[3]/form/ul/li/ul/div/div[1]/div/a[1]/div")).click();  //click on COnnect with another account          		
            driver.findElement(By.xpath("//*[@placeholder='Email Address']")).sendKeys(new CharSequence[] { un });
            driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys(new CharSequence[] { pw });
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id='btn-log-in']")).click();             
            Thread.sleep(3000);
        }
    }
}