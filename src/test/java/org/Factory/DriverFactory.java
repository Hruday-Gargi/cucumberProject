package org.Factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
	public static ThreadLocal<WebDriver>tlDriver=new ThreadLocal<WebDriver>();
	public static synchronized WebDriver getDriver()	{
		return tlDriver.get();
	}
public WebDriver startupTL(String browsName) {
	if(browsName.equalsIgnoreCase("chromeBrowser")||browsName.equalsIgnoreCase("ch")){
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("start-mximized");
		tlDriver.set(new ChromeDriver(options));
	}else if(browsName.equalsIgnoreCase("FirefoxBrowser")||browsName.equalsIgnoreCase("ff")){
		System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
		FirefoxOptions options=new FirefoxOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("start-mximized");
		tlDriver.set(new FirefoxDriver(options));
	}
	else {
		System.out.println("Invalid BrowserName");
	}
	getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	return getDriver();
}
}
