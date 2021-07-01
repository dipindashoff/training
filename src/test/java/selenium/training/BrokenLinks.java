package selenium.training;

import java.net.HttpURLConnection;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class BrokenLinks {

	public static void main(String[] args) {

		// Launch Browser/URL
		System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		InternetExplorerOptions options = new InternetExplorerOptions();
		options.requireWindowFocus();
		options.enablePersistentHovering();

		driver.get("http://golfclub.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		// Find all links
		List<WebElement> list = driver.findElements(By.tagName("a"));

		// Remove web elements with tag 'a' & no 'href' attribute
		list.removeIf(a -> a.getAttribute("href") == null);

		// OR using Java 8
		List<WebElement> list2 = driver.findElements(By.tagName("a")).stream()
				.filter(a -> a.getAttribute("href") != null).collect(Collectors.toList());

		for (WebElement element : list)
			// verify if the URL is broken
			verifyLinkIsBroken(element.getAttribute("href"));
		// OR using Java 8
		list2.forEach(x -> verifyLinkIsBroken(x.getAttribute("href")));

		// Close Driver
		tearDown(driver);

	}

	/*
	 * Create URL from String Open Connection using URl.openConnection() --> returns
	 * HttpURLConnection Wait for the connection to be open -->
	 * HttpURLConnection.setConnectTImeout(2000); Now connect to the URL using
	 * HttpURLConnection.connect() method After connecting, get response code using
	 * HttpURLConnection.getResponseCode() If response code == 200 --> OK URL works
	 * If response code == 404 --> URL not found
	 * 
	 */

	private static void verifyLinkIsBroken(String url) {

		try {
			URL link = new URL(url);

			// Create a connection using URL object (i.e., link)
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			// Set the timeout for 2 seconds
			httpConn.setConnectTimeout(2000);

			// connect using connect method
			httpConn.connect();

			// use getResponseCode() to get the response code.
			// OK URL works
			if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK)
				System.out.println(url + " - " + httpConn.getResponseMessage());

			// URL not found
			if (httpConn.getResponseCode() >= HttpURLConnection.HTTP_BAD_REQUEST)
				System.out.println(url + " - " + httpConn.getResponseMessage());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void tearDown(WebDriver driver) {
		driver.quit();
	}

}
