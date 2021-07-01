package selenium.training;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElements {

    public static void main(String... args) throws InterruptedException {
    	WebDriver driver;
    	
    	WebDriverManager.chromedriver().setup();
    	  ChromeOptions options = new ChromeOptions();
    	 options.setPageLoadStrategy(PageLoadStrategy.NONE);
         options.setExperimentalOption("useAutomationExtension", false);
         options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
         Map<String, Object> prefs = new HashMap<>();
         prefs.put("credentials_enable_service", false);
         prefs.put("profile.password_manager_enabled", false);
         options.setExperimentalOption("prefs", prefs);
         options.addArguments("-disable-save-password-bubble", "false");
         options.addArguments("-disable-extensions");
         options.addArguments("no-sandbox");
         options.addArguments("start-maximized");
    	driver = new ChromeDriver(options);
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	driver.manage().window().maximize();
    	
    	
    	driver.get("https://www.highcharts.com/demo/line-basic?__cf_chl_jschl_tk__=496032dfe4e075805a9a0bbbe1f9a4420fab5088-1588930826-0-AWOnnmwN93d6Z2mr1qN6f2tSps9nM5XX2ToKVfbzBfyGCSkUOPP9wrenMdMTW6qgyfm-uAH8ErFc4Hqjhd50YxhYzXRQvED_KJxPRu8SIN1COtSQD0EapJOi9VlMq2XhFWem9KP9Ww-O4ddNNzKD_wx-pGw-KWxdPYZ8O_1liSxo8t1piZHvedKypBXWhAl0pIKeYUEoAV40b7gK3C5gGBEeBQG1Dce7UglENOyLm7bX5IcmHt_18suNdUU2GC1eC2cOTic47xiAmJEn552TGRxqPh6abwJA5_pgtx1EyxJXeBUfGFFH9fnFwDDthwCC4XztF_K15obvdNG1gjLYXVQvCEbQqEi_qUCShHAQdqM0");
    	Thread.sleep(3000);
    	By by = By.xpath("//*[name()='svg' and @class='highcharts-root']//*[name()='g' and contains(@class,'highcharts-axis highcharts-yaxis')]//*[name()='text']//*[name()='tspan']");
    	WebElement element = driver.findElement(by);
    	System.out.println(element.getText());
    	
//    	if (driver != null) 
//            driver.quit();
    	
    }

}
