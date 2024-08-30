package org.Utilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Baseutility {
	
	public void scrollByPageDown(WebDriver driver,int scrollnum){
		for(int i=1;i<=scrollnum;i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);
		}
	}
	public void scrollByJavaScript(WebDriver driver,WebElement ele){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",ele);
	}
	public boolean isAlertPresent(WebDriver driver,long time){
		try {
		WebDriverWait wt=new WebDriverWait(driver,Duration.ofSeconds(time));
		wt.until(ExpectedConditions.alertIsPresent());
		return true;
		}catch(TimeoutException e) {
		return false;
	}
}
	public void clickByActions(WebDriver driver,WebElement ele){
		Actions act=new Actions(driver);
		act.click(ele).perform();
	}
	public void sendKeysByActions(WebDriver driver,WebElement ele,String text ){
     Actions act=new Actions(driver);
     act.sendKeys(ele, "text").build().perform();
	}
 	public WebDriver startup(String browseName,String url ){
		WebDriver driver=null;
		if(browseName.equalsIgnoreCase("chromebrowser")){
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.addArguments("start-maximized");   //open maximized browser
			options.addArguments("--disable-notification");   //to disable notifications,coockies.
//			options.addArguments("headless");      //for background work
			driver=new ChromeDriver(options);  //to open browser
		}else if(browseName.equalsIgnoreCase("firefoxbrowser")){
			System.setProperty("webdriver.gecko.driver", "./seleniumpractice/drivers/chromedriver.exe");
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("start-maximized");   //open maximized browser
			options.addArguments("--disable-notification");   //to disable notifications,coockies.
//			options.addArguments("headless");      //for background work
			driver=new FirefoxDriver(options);  //to open browser
		    
		}else if(browseName.equalsIgnoreCase("edge")){
			System.setProperty("webdriver.edge.driver", "./seleniumpractice/drivers/chromedriver.exe");
			EdgeOptions options=new EdgeOptions();
			options.addArguments("start-maximized");   //open maximized browser
			options.addArguments("--disable-notification");   //to disable notifications,coockies.
//			options.addArguments("headless");      //for background work
			driver=new EdgeDriver(options);  //to open browser
		}else {
			System.out.println("invalid browser !!");
		   }
		driver.get(url);
		return driver;
	}
 	public void waitForVisibilitiOfWebElement(WebDriver driver,WebElement ele,long time){
		WebDriverWait wt=new WebDriverWait(driver,Duration.ofSeconds(time));
		wt.until(ExpectedConditions.visibilityOf(ele));		
	}
	public void waitForTitlecontains(WebDriver driver,long time,String titlepart){
		WebDriverWait wt=new WebDriverWait(driver,Duration.ofSeconds(time));
		wt.until(ExpectedConditions.titleContains(titlepart));		
	}
	public void waitForUrlContains(WebDriver driver,long time,String urlpart){
		WebDriverWait wt=new WebDriverWait(driver,Duration.ofSeconds(time));
		wt.until(ExpectedConditions.urlContains(urlpart));
	}
	public void clickByJavaScript(WebDriver driver,WebElement ele){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",ele);
	}
	public void waitForVisibilityOfWebElementType(WebDriver driver,long time,String type,String expression) {
		WebDriverWait wt=new WebDriverWait(driver,Duration.ofSeconds(time));
		if(type.equalsIgnoreCase("id")) {
			wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(expression))));
			}else if(type.equalsIgnoreCase("className")) {
				wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(expression))));
			}else if(type.equalsIgnoreCase("cssSelector")) {
				wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(expression))));
			}else if(type.equalsIgnoreCase("xpath")) {
				wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(expression))));
	        }else if(type.equalsIgnoreCase("linkText")) {
				wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(expression))));
	        }else if(type.equalsIgnoreCase("partiallinkText")) {
				wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.partialLinkText(expression))));
	        }else if(type.equalsIgnoreCase("name")) {
				wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.name(expression))));
	        }else if(type.equalsIgnoreCase("tagName")) {
				wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName(expression))));
	        }
	   }	
    public void waitForVisibilityOfWebElementLocated(WebDriver driver,long time,String type,String expression) {
	WebDriverWait wt=new WebDriverWait(driver,Duration.ofSeconds(time));
    if(type.equalsIgnoreCase("id")) {
	   wt.until(ExpectedConditions.visibilityOfElementLocated(By.id(expression)));
     } else if(type.equalsIgnoreCase("class")) {
	   wt.until(ExpectedConditions.visibilityOfElementLocated(By.className(expression)));
     } else if(type.equalsIgnoreCase("linkText")) {
	   wt.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(expression)));
     }else if(type.equalsIgnoreCase("PartiallinkText")) {
	   wt.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(expression)));
     }else if(type.equalsIgnoreCase("cssSelector")) {
	   wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(expression)));
     }else if(type.equalsIgnoreCase("name")) {
	   wt.until(ExpectedConditions.visibilityOfElementLocated(By.name(expression)));
     }else if(type.equalsIgnoreCase("tagName")) {
	   wt.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(expression)));
     }else if(type.equalsIgnoreCase("xpath")) {
	   wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(expression)));
     }
   }
    public  ArrayList<String> getAllTextFromList (List<WebElement>allele){
	ArrayList<String>ar=new ArrayList<String>();
	for(int i=0;i<allele.size();i++) {
		ar.add(allele.get(i).getText());
	}
	return ar;
	}
}

