package com.easygov.automation;

import static com.easygov.automation.utils.ConfigPropertyReader.getProperty;
import static com.easygov.automation.utils.YamlReader.getYamlValue;
import static com.easygov.automation.utils.YamlReader.setYamlFilePath;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.easygov.automation.utils.TakeScreenshot;

import com.easygov.keywords.Scheme;

import com.easygov.keywords.YamlInformationProvider;

public class TestSessionInitiator {

	protected WebDriver driver;
	private final WebDriverFactory wdfactory;
	static String browser;
	String seleniumserver;
	String seleniumserverhost;
	String appbaseurl;
	String applicationpath;
	String chromedriverpath;
	String datafileloc = "";
	static int timeout;
	Map<String, Object> chromeOptions = null;
	DesiredCapabilities capabilities;

	public YamlInformationProvider yaml;
	/**
	 * Initiating the page objects
	 */

	public Scheme scheme;
	
	
	public TakeScreenshot takescreenshot;

	public WebDriver getDriver() {
		return this.driver;
	}

	private void _initPage() {
		
		
		yaml = new YamlInformationProvider();
		scheme= new Scheme(driver);
	}

	/**
	 * Page object Initiation done
	 */

	public TestSessionInitiator(String testname) {
		wdfactory = new WebDriverFactory();
		testInitiator(testname);
	}

	private void testInitiator(String testname) {
		setYamlFilePath();
		_configureBrowser();
		_initPage();
		takescreenshot = new TakeScreenshot(testname, this.driver);
		launchApplication();
	}

	public static String getBrowser() {
		if (System.getProperty("browser") == null) {
			browser = getProperty("./Config.properties", "browser");
		} else
			browser = System.getProperty("browser");
		return browser;
	}

	private void _configureBrowser() {
		driver = wdfactory.getDriver(_getSessionConfig());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(getProperty("timeout")), TimeUnit.SECONDS);
	}

	private Map<String, String> _getSessionConfig() {
		String[] configKeys = { "tier", "browser", "seleniumServer", "seleniumServerHost", "timeout" };
		Map<String, String> config = new HashMap<String, String>();
		for (String string : configKeys) {
			config.put(string, getProperty("./Config.properties", string));
		}
		return config;
	}

	public void launchApplication() {
		launchApplication(getYamlValue("url"));
	}

	public void launchApplication(String baseurl) {
		System.out.println("\n" + "The test browser is :- " + getBrowser() + "\n");
		deleteAllCookies();
		driver.get(baseurl);
		System.out.println("\nThe application url is :- " + baseurl);
		// handleSSLCertificateCondition();
	}

	public void openUrl(String url) {
		driver.get(url);
	}

//	public void closeBrowserSession() {
//		try {
//			if (driver == null) {
//				System.out.println("Browser Window is closed");
//			}
//			else {
//				driver.close();
//				driver.quit();
//			}
//		    } 
//		
//		    catch (Exception e) {
//		    	System.out.println("Browser Window is closed");
//		    	
//		      }
//		
//	}
	
	public void closeBrowserSession() {
	driver.close();
	driver.quit();
	}
	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}

	public void closeBrowserWindow() {
		driver.close();
	}

	public void handleSSLCertificateCondition() {
		if (driver.getTitle().contains("Certificate Error")) {
			driver.get("javascript:document.getElementById('overridelink').click();");
			System.out.println("Step : handle SSL certificate condition\n");
		}
		if (driver.getTitle().contains("Certificate Error")) {
			driver.get("javascript:document.getElementById('overridelink').click();");
			System.out.println("Step : handle SSL certificate condition\n");

		} else {

		}

	}

}
