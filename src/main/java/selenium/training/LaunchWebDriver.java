package selenium.training;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.Select;

public class LaunchWebDriver {

	public static void main(String[] args) {

		try {
			// Launch WebDriver
			System.setProperty("webdriver", "IEDriver.exe");
			WebDriver driver = new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			InternetExplorerOptions opt = new InternetExplorerOptions();
			opt.requireWindowFocus();
			opt.enablePersistentHovering();

			String url = "";
//		url = "https://www.google.com";
			url = "https://www.jobserve.com/in/en/Job-Search/";
			driver.get(url);

			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();

			By span = By.xpath("//span[contains(@class,'ui-dropdownchecklist-text')]");
			driver.findElement(span).click();

			// Uncheck All
			By selectAllCheckbox = By.xpath(
					"//label[normalize-space(text())='Select All Industries']/preceding-sibling::input[@type='checkbox']");
			driver.findElement(selectAllCheckbox).click();

			List<WebElement> list = driver.findElements(By.xpath(
					"//div[@id='ddcl-selInd-ddw']//*[@type='checkbox' and contains(@id,'ddcl-selInd-i')]/following-sibling::label"));

			System.out.println(list.size());
			int i = 1;
			for (WebElement wb : list) {

				By xb = By.xpath("//div[@id='ddcl-selInd-ddw']//*[@type='checkbox' and contains(@id,'ddcl-selInd-i')]["
						+ i + "]");

				By xbLabel = By.xpath(
						"(//div[@id='ddcl-selInd-ddw']//*[@type='checkbox' and contains(@id,'ddcl-selInd-i')]/following-sibling::label)["
								+ i + "]");

				System.out.println("xbLabel: " + driver.findElement(xbLabel).getText());

				System.out.println(wb.getText().trim());

				if (wb.getText().trim().equals("Engineering")) {
					wb.click();
					driver.findElement(xb).click();

					break;
				}
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
