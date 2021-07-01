package selenium.training;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtilities {
	static WebDriver driver;

	public static void keyboardActions() {

		Actions action = new Actions(driver);
		action.sendKeys(Keys.chord(Keys.ENTER)).perform();
	}

	public static void wait(By by) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public static void highlightElement(By by) {
		WebElement element = driver.findElement(by);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', 'border: solid 2px blue')",
				element);
	}

	public static void click(By by) {
		WebElement element = driver.findElement(by);
		element.click();

		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
	}

	public static void hoverOver(By by) {
		(new Actions(driver)).moveToElement(driver.findElement(by)).build().perform();
	}

	public static void scrollToElement(By by) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollToView()", driver.findElement(by));
	}

	public static void enterText(By by, String value) {

		driver.findElement(by).sendKeys(value);
		((JavascriptExecutor) driver).executeScript("arguments[0].value='" + value + "';", driver.findElement(by));
	}

	public static String getAttribute(By by, String attributeName) {
		return driver.findElement(by).getAttribute(attributeName);
	}

	public static void selectDropDown(By by, String value) {
		(new Select(driver.findElement(by))).selectByVisibleText(value);
	}

	public static void takeScreenshot(By by, String dest) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(src, new File(dest)); Add Commons IO jars
	}

	public static void robotScreenshot(String dest) throws AWTException, IOException {

		Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage img = (new Robot()).createScreenCapture(rectangle);
		ImageIO.write(img, "jpeg", new File(dest));
	}

//	public static void getScenarioTagName(Scenario scenario) {
//		
//		Collection<String> tagName = scenario.getSourceTagNames();
//		//TODO
//	}

}
